package finalProject.eeit10904.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import finalProject.eeit10904.interceptor.AuthorizationInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan("finalProject")
public class WebAppConfig implements WebMvcConfigurer {
	// 視圖解析器
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	// 部署靜態資源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**")
			.addResourceLocations("/WEB-INF/views/css/");
		registry.addResourceHandler("/images/**")
			.addResourceLocations("/WEB-INF/views/images/");
		registry.addResourceHandler("/assets/**")
			.addResourceLocations("/WEB-INF/views/assets/");
		registry.addResourceHandler("/js/**").
			addResourceLocations("/WEB-INF/views/js/");
		registry.addResourceHandler("/dist/**").
			addResourceLocations("/WEB-INF/views/dist/");
	}
	
	// 參照resources裡的資料.properties時，開頭為messages
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
		resource.setBasename("messages");
		return resource;
	}
	
	@Bean
	public MappingJackson2JsonView jsonView() {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		//印出整理過後比較可讀的json
		view.setPrettyPrint(true);
		return view;
	}
	
	// 內容協商解析器
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		ArrayList<View> views = new ArrayList<>();
		views.add(jsonView());
		resolver.setDefaultViews(views);
		return resolver;
	}

	// 配置攔截器
	@Autowired
	private AuthorizationInterceptor authorizationInterceptor;
	
	// 攔截器先全部攔截後再以白名單放行login頁面，
	// 亦即除了login之外都要先經過攔截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorizationInterceptor).
			addPathPatterns("/*").excludePathPatterns("/login");
	}
	
	// 檔案上傳
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);//78.125mb
		return resolver;
	}
	
//	// 品妤的視圖解析器
//	@Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);(舊版寫法，憲春說過不用加這行)
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        registry.viewResolver(viewResolver);
//    }
}
