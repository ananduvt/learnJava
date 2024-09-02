package avt.learn.challenge.service;

import avt.learn.challenge.base.BaseProblem;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Slf4j
@Configuration
public class Config implements BeanDefinitionRegistryPostProcessor {

    @Bean
    public void registerSubClass() {

        // TODO: auto bean creation for problem class without @component anotation
        Reflections reflections = new Reflections("avt.learn.challenge.problem");

        Set<Class<? extends BaseProblem>> subClasses = reflections.getSubTypesOf(BaseProblem.class);
        for (Class<? extends BaseProblem> subClass : subClasses) {
            //BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(subClass).setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();
           // BeanDefinitionRegistry
            registerBeanClass(subClass);

        }
    }

    @SneakyThrows
    private <T> void registerBeanClass(Class<T> beanClass) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(beanClass);
        //((AnnotationConfigApplicationContext) applicationContext).registerBean(beanClass, beanClass::getDeclaredConstructor);

    }


    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // no inplementation
    }
}
