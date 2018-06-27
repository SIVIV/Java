package spring_intro.product_shop.utlls.beans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import spring_intro.product_shop.utlls.config.ModelMapperConfig;

@Component
public class BeanRegister {
    @Bean
    public Gson getGson(){
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper getMapper(){
        return new  ModelMapper();
    }
}
