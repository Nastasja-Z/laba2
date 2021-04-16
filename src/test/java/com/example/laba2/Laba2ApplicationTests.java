package com.example.laba2;

import com.example.laba2.entity.Donation;
import com.example.laba2.entity.Needy;
import com.example.laba2.entity.Option;
import com.example.laba2.reporitory.DonationRepository;
import com.example.laba2.reporitory.NeedyRepository;
import com.example.laba2.service.HelpOnNeedies;
import com.example.laba2.service.impl.HelpOnNeediesImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
@Transactional
@Rollback
class Laba2ApplicationTests {

	/*@Test
	void contextLoads() {
	}*/

//	@Autowired
//	private DonationRepository donationRepository;

    @Autowired
    private NeedyRepository needyRepository;

    @Autowired
    private HelpOnNeedies helpOnNeedies;

    private final static String NAME_OF_NEEDY = "Юлия Мирная";

    @BeforeEach
    private void fillData() {
        needyRepository.saveAll(getAllNeediesData());
    }

//	// Все нуждающиеся

//	Set<Needy> needies = helpOnNeedies.getAllDonations();
//        System.out.println("Все нуждающиеся");
//        for (Needy needy :
//	needies) {
//		System.out.println(needy.toString());
//	}

    @Test
    public void findAllNeediesTest() {
        Set<Needy> needies = helpOnNeedies.getAllDonations();
        Assertions.assertEquals(3, needies.size());
    }


//	//Все опции для одного нуждающегося

    //	Set<Option> optionsForNeedy = helpOnNeedies.getOptionForNeedy(NAME_OF_NEEDY);
//        System.out.println("\nВсе опции для [" + NAME_OF_NEEDY + "]");
//        for (Option option :
//	optionsForNeedy) {
//		System.out.println(option.toString());
//
//	}
    @Test
    public void getAllOptionsForOneNeedyTest() {
        Set<Option> optionsForNeedy = helpOnNeedies.getOptionForNeedy(NAME_OF_NEEDY);
        Assertions.assertEquals(2, optionsForNeedy.size());
    }

//
//	//Сделать пожертвование
//	//Изменение переменной
//        System.out.println("\nСделать пожертвование для [" + NAME_OF_NEEDY + "]");
//	Donation donation = helpOnNeedies.payForOption(1,NAME_OF_NEEDY, 1);
//
//	//Моделирование исключения
//        System.out.println("\nМоделирование исключения");
//        helpOnNeedies.payForOption(1,NAME_OF_NEEDY, 8);

    @Test
    public void payForOptionTest() {
        Assertions.assertThrows(RuntimeException.class, () ->
                helpOnNeedies.payForOption(NAME_OF_NEEDY, 8));
    }


    private List<Option> getAllOptionsData() {
        Option option1 = new Option();
        //option1.setId(1);
        option1.setNameOfOption("стандартный набор еды");
        option1.setPrice(250);

        Option option2 = new Option();
        //option2.setId(2);
        option2.setNameOfOption("улучшеный набор еды");
        option2.setPrice(500);

        Option option3 = new Option();
        //option3.setId(3);
        option3.setNameOfOption("осмотр у врача");
        option3.setPrice(300);

        return Arrays.asList(option1, option2, option3);

    }

    private Set<Needy> getAllNeediesData() {
        Set needies = new HashSet();
        List<Option> options = getAllOptionsData();

        Needy needy1 = new Needy();
        //needy1.setId(1);
        needy1.setNameOfNeedy("Юлия Мирная");
        needy1.setStatus("беженка");
        Set<Option> julia = new HashSet<>();// = options.stream().filter(value -> value.getId().equals(1) || value.getId().equals(2)).collect(Collectors.toSet());
        julia.add(options.get(1));
        julia.add(options.get(2));

        needy1.setOptions(julia);

        Needy needy2 = new Needy();
        //needy2.setId(2);
        needy2.setNameOfNeedy("Матвей Лесовой");
        needy2.setStatus("пенсиоер");
        Set<Option> mathew = new HashSet<>();// options.stream().filter(value -> value.getId().equals(3) || value.getId().equals(2)).collect(Collectors.toSet());
        //mathew.add(options.get(3));
        mathew.add(options.get(2));

        needy2.setOptions(mathew);

        Needy needy3 = new Needy();
        //needy3.setId(3);
        needy3.setNameOfNeedy("Гарик Маликов");
        needy3.setStatus("инвалид 3й степени");
        Set<Option> garik = new HashSet<>();// options.stream().filter(value -> value.getId().equals(1)).collect(Collectors.toSet());
        garik.add(options.get(1));
        needy3.setOptions(garik);

        needies.add(needy1);
        needies.add(needy2);
        needies.add(needy3);

        return needies;
    }

}
