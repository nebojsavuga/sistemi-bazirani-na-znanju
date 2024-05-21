package com.ftn.sbnz.service;

import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.drools.template.DataProviderCompiler;
import org.drools.template.objects.ArrayDataProvider;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.drools.template.DataProvider;

@EnableJpaRepositories("com.ftn.sbnz.*")
@ComponentScan(basePackages = { "com.ftn.sbnz.*" })
@EntityScan("com.ftn.sbnz.*")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks
				.newKieContainer(ks.newReleaseId("com.ftn.sbnz", "kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(1000);
		return kContainer;
	}

	@Bean
    public KieBase templateKieBase() {
        InputStream tenisStream = this.getClass().getResourceAsStream("/rules/basic/tenis-template.drt");
        DataProvider dataProviderTenis = new ArrayDataProvider(new String[][]{
                {"Tenis", "0.0", "100.0", "17.0"},
                {"Tenis", "100.0", "108.0", "19.0"},
                {"Tenis", "109.0", "115.0", "21.0"},
                {"Tenis", "116.0", "125.0", "23.0"},
                {"Tenis", "126.0", "140.0", "25.0"},
                {"Tenis", "141.0", "155.0", "26.0"},
                {"Tenis", "156.0", "190.0", "27.0"},
                {"Tenis", "191.0", "250.0", "27.5"},
                
                
        });
        DataProviderCompiler converter = new DataProviderCompiler();
        String tenisDrl = converter.compile(dataProviderTenis, tenisStream);

        InputStream weightStream = this.getClass().getResourceAsStream("/rules/basic/weight-template.drt");
        DataProvider dataProviderWeight = new ArrayDataProvider(new String[][]{
                {"DizanjeTegova", "Rekreativac", "Musko", "15.0"},
                {"DizanjeTegova", "Amater", "Musko", "45.0"},
                {"DizanjeTegova", "Pro", "Musko", "60.0"},
                {"DizanjeTegova", "Rekreativac", "Zensko", "10.0"},
                {"DizanjeTegova", "Amater", "Zensko", "30.0"},
                {"DizanjeTegova", "Pro", "Zensko", "45.0"},
                
        });
        String weightDrl = converter.compile(dataProviderWeight, weightStream);

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(tenisDrl, ResourceType.DRL);
        kieHelper.addContent(weightDrl, ResourceType.DRL);

        KieServices kieServices = KieServices.Factory.get();
        kieHelper.addResource(kieServices.getResources().newClassPathResource("rules/basic/templates.drl"), ResourceType.DRL);

        KieBase kieBase = kieHelper.build();
        return kieBase;
    }

    @Bean
    public KieSession templateKsession() {
        return templateKieBase().newKieSession();
    }
}
