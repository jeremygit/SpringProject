package com.example.Spring5

import com.example.Spring5.controllers.ObjectifyEntity1
import com.example.Spring5.entitys.ListingEntity
import com.googlecode.objectify.ObjectifyFilter
import com.googlecode.objectify.ObjectifyService
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.servlet.ServletContextEvent
import javax.servlet.ServletContextListener

@Configuration
class ServletInitializer : SpringBootServletInitializer() {

	override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
		return application.sources(Spring5Application::class.java)
	}

	@Bean
	fun objectifyFilter(): FilterRegistrationBean<ObjectifyFilter> {
		val reg = FilterRegistrationBean<ObjectifyFilter>()
		reg.filter = ObjectifyFilter()
		reg.addUrlPatterns("/*")
		reg.setName("ofyFilter")
		return reg
	}

	@Bean
	fun objectifyListener(): ServletListenerRegistrationBean<ObjectifyListener> {
		val reg = ServletListenerRegistrationBean<ObjectifyListener>()
		reg.listener = ObjectifyListener()
		return reg
	}

}

class ObjectifyListener: ServletContextListener {
	override fun contextInitialized(sce: ServletContextEvent) {
		ObjectifyService.init()
		ObjectifyService.register(ObjectifyEntity1::class.java)
		ObjectifyService.register(ListingEntity::class.java)
	}
}



//	Alternatively for Filtering
//	@WebFilter(urlPatterns = {"/*"})
//	public class ObjectifyWebFilter extends ObjectifyFilter {}
