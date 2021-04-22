package com.example.laba2.service.impl;

import com.example.laba2.entity.Donation;
import com.example.laba2.entity.Needy;
import com.example.laba2.entity.Option;
import com.example.laba2.reporitory.DonationRepository;
import com.example.laba2.reporitory.NeedyRepository;
import com.example.laba2.service.HelpOnNeedies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class HelpOnNeediesImpl implements HelpOnNeedies {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private NeedyRepository needyRepository;

    @Override
    public Set<Needy> getAllDonations() {
        return needyRepository.findAll();
    }

    @Override
    public Set<Option> getOptionForNeedy(String nameOfNeedy) {

        Optional<Needy> options = needyRepository.findByNameOfNeedy(nameOfNeedy);
        return options.get().getOptions();
    }


    @Override
    @Transactional
    public Donation payForOption(String nameOFNeedy, int idOfOption) {
        Donation donations = new Donation();

        Needy needies = needyRepository.findByNameOfNeedy(nameOFNeedy).orElse(null);


        Option option = needies.getOptions().stream().filter(value -> value.getId().equals(idOfOption)).findFirst().orElse(null);

        if (needies == null) {
            throw new IllegalArgumentException("There is no needy such [" + nameOFNeedy + "]");
        } else if (option == null) {
            throw new RuntimeException("There is no option with ID like [" + idOfOption + "]");
        } else {
            donations.setNeedy(needies);
            donations.setOption(option);

            return donationRepository.save(donations);
        }

    }


    private List<Option> getAllOptionsData() {
        Option option1 = new Option();
        option1.setNameOfOption("стандартный набор еды");
        option1.setPrice(250);

        Option option2 = new Option();
        option2.setNameOfOption("улучшеный набор еды");
        option2.setPrice(500);

        Option option3 = new Option();
        option3.setNameOfOption("осмотр у врача");
        option3.setPrice(300);

        return Arrays.asList(option1, option2, option3);

    }

    private Set<Needy> getAllNeediesData() {
        Set needies = new HashSet();
        List<Option> options = getAllOptionsData();

        Needy needy1 = new Needy();
        needy1.setId(1);
        needy1.setNameOfNeedy("Юлия Мирная");
        needy1.setStatus("беженка");
        Set<Option> julia = options.stream().filter(value -> value.getId().equals(1) || value.getId().equals(2)).collect(Collectors.toSet());
        needy1.setOptions(julia);

        Needy needy2 = new Needy();
        needy2.setId(2);
        needy2.setNameOfNeedy("Матвей Лесовой");
        needy2.setStatus("пенсиоер");
        Set<Option> mathew = options.stream().filter(value -> value.getId().equals(3) || value.getId().equals(2)).collect(Collectors.toSet());
        needy2.setOptions(mathew);

        Needy needy3 = new Needy();
        needy3.setId(3);
        needy3.setNameOfNeedy("Гарик Маликов");
        needy3.setStatus("инвалид 3й степени");
        Set<Option> garik = options.stream().filter(value -> value.getId().equals(1)).collect(Collectors.toSet());
        needy3.setOptions(garik);

        needies.add(needy1);
        needies.add(needy2);
        needies.add(needy3);

        return needies;
    }

}
