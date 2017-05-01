package br.com.casadocodigo.loja.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.common.cache.CacheBuilder;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.infra.FileSaver;
import br.com.casadocodigo.loja.models.CarrinhoCompras;



@EnableWebMvc
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class, 
		FileSaver.class, CarrinhoCompras.class}) //injeta classes dos pacotes das classes indicadas
@EnableCaching//habilita o cache com o metodo cacheManager abaixo, para utilizar igual homeController
public class AppWebConfiguration extends WebMvcConfigurerAdapter{//extends para load resources static
	
	@Bean//seta local aonde estarao as views e sufixo das paginas
	public InternalResourceViewResolver internalResourceViewResolver(){
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/views/");
	    resolver.setSuffix(".jsp");
	    
	    //expor algum bean especifico
	    resolver.setExposedContextBeanNames("carrinhoCompras");
	    //export todos os beans
//	    resolver.setExposeContextBeansAsAttributes(true);
	    
	    return resolver;
	}
	
	
	@Bean//seta encoding
	public MessageSource messageSource(){
	    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	    messageSource.setBasename("/WEB-INF/messages");
	    messageSource.setDefaultEncoding("UTF-8");
	    messageSource.setCacheSeconds(1);
	    return messageSource;
	}
	
	@Bean//registra padroes de formatacoes
	public FormattingConversionService mvcConversionService(){
	    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
	    DateFormatterRegistrar formatterRegistrar = new DateFormatterRegistrar();
	    formatterRegistrar.setFormatter(new DateFormatter("dd/MM/yyyy"));
	    formatterRegistrar.registerFormatters(conversionService);

	    return conversionService;
	}
	
    @Bean
    public MultipartResolver multipartResolver(){ //configura envio de arquivos
        return new StandardServletMultipartResolver();
    }
   
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { //load css e img
        registry.addResourceHandler("/resources/**").addResourceLocations(
                "/resources/");
    }    
    
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
    
    @Bean
    public CacheManager cacheManager() {
    	CacheBuilder<Object,Object> cacheBuilder = CacheBuilder.newBuilder()
    		.maximumSize(100)
    		.expireAfterAccess(5, TimeUnit.MINUTES);
    	GuavaCacheManager manager = new GuavaCacheManager();
    	manager.setCacheBuilder(cacheBuilder);
    		
    	return manager;
    }
}
