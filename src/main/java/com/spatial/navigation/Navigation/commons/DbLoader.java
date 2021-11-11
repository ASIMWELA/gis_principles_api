package com.spatial.navigation.Navigation.commons;

import com.spatial.navigation.Navigation.customer.Customer;
import com.spatial.navigation.Navigation.customer.CustomerService;
import com.spatial.navigation.Navigation.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DbLoader {
    @Bean
    CommandLineRunner init(CustomerService customerService, CustomerRepository customerRepository){
        return args -> {

            //clean db
            customerRepository.deleteAll();


            Customer customer1 = Customer.builder().locationName("Blantyre")
                                        .firstName("Salome")
                                        .lastName("Simwela")
                                        .userName("Ssimwela")
                                        .build();
            customerService.saveCustomer(customer1, -15.7861, 35.0058);

            Customer customer2 = Customer.builder().locationName("Lilongwe")
                    .firstName("Augustine")
                    .lastName("Simwela")
                    .userName("Asimwela")
                    .build();
            customerService.saveCustomer(customer2, -13.9833, 33.7833);

            Customer customer3 = Customer.builder().locationName("Mzuzu")
                    .firstName("Joseph")
                    .lastName("Simwela")
                    .userName("Jsimwela")
                    .build();
            customerService.saveCustomer(customer3, -11.4500, 34.0333);

            Customer customer4 = Customer.builder().locationName("Mzuzu")
                    .firstName("Nelson")
                    .lastName("Simwela")
                    .userName("nsimwela")
                    .build();
            customerService.saveCustomer(customer4, -11.4500, 34.0333);

            Customer customer5 = Customer.builder().locationName("Zomba")
                    .firstName("Victoria")
                    .lastName("Simwela")
                    .userName("vsimwela")
                    .build();
            customerService.saveCustomer(customer5, -15.3833, 35.3333);

            Customer customer6 = Customer.builder().locationName("Salima")
                    .firstName("Gibson")
                    .lastName("Simwela")
                    .userName("gsimwela")
                    .build();
            customerService.saveCustomer(customer6, -13.7829, 34.4333);


            Customer customer7 = Customer.builder().locationName("Nkhotakota")
                    .firstName("Abraham")
                    .lastName("Simwela")
                    .userName("Absimwela")
                    .build();
            customerService.saveCustomer(customer7, -12.9163, 34.3000);

            Customer customer123 = Customer.builder().locationName("Mangochi")
                    .firstName("Edwin")
                    .lastName("Simwela")
                    .userName("esimwela")
                    .build();
            customerService.saveCustomer(customer123, -14.4781, 35.2645);

            Customer customer132 = Customer.builder().locationName("Karonga")
                    .firstName("Daelo")
                    .lastName("Namaumbo")
                    .userName("dnamaumbo")
                    .build();
            customerService.saveCustomer(customer132, -9.9329, 33.9333);

            Customer customer9 = Customer.builder().locationName("Chiromo")
                    .firstName("Israel")
                    .lastName("Malunga")
                    .userName("imalunga")
                    .build();
            customerService.saveCustomer(customer9, -16.5500, 35.1332);

            Customer customer10 = Customer.builder().locationName("Nkhatabay")
                    .firstName("Molly")
                    .lastName("Phiri")
                    .userName("mphiri")
                    .build();
            customerService.saveCustomer(customer10, -11.6333, 34.3000);

            Customer customer11 = Customer.builder().locationName("Nsanje")
                    .firstName("Stencia")
                    .lastName("Gondwe")
                    .userName("gdondwe")
                    .build();
            customerService.saveCustomer(customer11, -16.9167, 35.2667);

            Customer customer12 = Customer.builder().locationName("Mulanje")
                    .firstName("Fact")
                    .lastName("Chunga")
                    .userName("fchunga")
                    .build();
            customerService.saveCustomer(customer12, -16.0316, 35.5000);

            Customer customer13 = Customer.builder().locationName("Mzimba")
                    .firstName("Martin")
                    .lastName("Chunga")
                    .userName("mchunga")
                    .build();
            customerService.saveCustomer(customer13, -11.9000, 33.6000);

            Customer customer14 = Customer.builder().locationName("Mchinji")
                    .firstName("Mphatso")
                    .lastName("Phiri")
                    .userName("mphiri")
                    .build();
            customerService.saveCustomer(customer14, -13.8167, 32.9000);

            Customer customer15 = Customer.builder().locationName("Dedza")
                    .firstName("Boby")
                    .lastName("sir")
                    .userName("sirboby")
                    .build();
            customerService.saveCustomer(customer15, -14.3667, 34.3333);

            Customer customer16 = Customer.builder().locationName("Chitipa")
                    .firstName("John")
                    .lastName("Doe")
                    .userName("jdoe")
                    .build();
            customerService.saveCustomer(customer16, -9.7019, 33.2700);


            Customer customer17 = Customer.builder().locationName("Mwanza")
                    .firstName("Justice")
                    .lastName("Mkweza")
                    .userName("mjustice")
                    .build();
            customerService.saveCustomer(customer17, -15.6167, 34.5167);


            Customer customer18 = Customer.builder().locationName("Ntcheu")
                    .firstName("Super")
                    .lastName("Mario")
                    .userName("smario")
                    .build();
            customerService.saveCustomer(customer18, -14.8167, 34.6333);


            Customer customer19 = Customer.builder().locationName("Thyolo")
                    .firstName("Khumzy")
                    .lastName("Kumwenda")
                    .userName("kmwenda")
                    .build();
            customerService.saveCustomer(customer19, -16.0667, 35.1333);


            Customer customer20 = Customer.builder().locationName("Chiradzulu")
                    .firstName("George")
                    .lastName("Chunga")
                    .userName("jchunga")
                    .build();
            customerService.saveCustomer(customer20, -15.7167, 35.2000);


            Customer customer21 = Customer.builder().locationName("Machinga")
                    .firstName("Kulo")
                    .lastName("Mphosi")
                    .userName("mphosi")
                    .build();
            customerService.saveCustomer(customer21, -14.9667, 35.5167);


            Customer customer22 = Customer.builder().locationName("Rumphi")
                    .firstName("Deadly")
                    .lastName("prey")
                    .userName("json")
                    .build();
            customerService.saveCustomer(customer22, -11.0153, 33.7722);


            Customer customer23 = Customer.builder().locationName("Balaka")
                    .firstName("Sangwi")
                    .lastName("Mkondowe")
                    .userName("Sangwani")
                    .build();
            customerService.saveCustomer(customer23, -14.9889, 34.9591);


            Customer customer24 = Customer.builder().locationName("Phalombe")
                    .firstName("Solo")
                    .lastName("Satoa")
                    .userName("ssato")
                    .build();
            customerService.saveCustomer(customer24, -15.8000, 35.6500);


            Customer customer25 = Customer.builder().locationName("Chikwawa")
                    .firstName("Mkonda")
                    .lastName("Joseph")
                    .userName("Joseph")
                    .build();
            customerService.saveCustomer(customer25, -16.0350, 34.8010);


            Customer customer26 = Customer.builder().locationName("Kasungu")
                    .firstName("Phiri")
                    .lastName("Phiri")
                    .userName("phiri")
                    .build();
            customerService.saveCustomer(customer26, -13.0364, 33.4822);


            Customer customer27 = Customer.builder().locationName("Dowa")
                    .firstName("Clean")
                    .lastName("Mac")
                    .userName("Maclean")
                    .build();
            customerService.saveCustomer(customer27, -13.6532, 33.9385);


            Customer customer28 = Customer.builder().locationName("Neno")
                    .firstName("Josia")
                    .lastName("Osiman")
                    .userName("josi")
                    .build();
            customerService.saveCustomer(customer28, -15.3981, 34.6534);


            Customer customer29 = Customer.builder().locationName("Ntchisi")
                    .firstName("Dan")
                    .lastName("Mpande")
                    .userName("dmphande")
                    .build();
            customerService.saveCustomer(customer29, -13.3753, 34.0036);
        };
    }
}
