package com.example.laba2.service;

import com.example.laba2.entity.Donation;
import com.example.laba2.entity.Needy;
import com.example.laba2.entity.Option;

import java.util.Optional;
import java.util.Set;

public interface HelpOnNeedies {

    Set<Needy> getAllDonations();

    Set<Option> getOptionForNeedy(String nameOfNeedy);

    Donation payForOption(String nameOFNeedy, int idOfOption);

}
