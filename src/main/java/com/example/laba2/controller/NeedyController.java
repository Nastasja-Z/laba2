package com.example.laba2.controller;

import com.example.laba2.controller.dto.DonationDTO;
import com.example.laba2.entity.Needy;
import com.example.laba2.entity.Option;
import com.example.laba2.service.HelpOnNeedies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class NeedyController {

    @Autowired
    private HelpOnNeedies helpOnNeedies;

    @RequestMapping(value = "/needy", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Needy> getAllDonations() {
        return helpOnNeedies.getAllDonations();
    }

    @GetMapping("/needy/option/{nameOfNeedy}")
    @ResponseBody
    public Collection<Option> getOptionForNeedy(@PathVariable("nameOfNeedy") String nameOfNeedy) {
        return helpOnNeedies.getOptionForNeedy(nameOfNeedy);
    }

    @RequestMapping(value = "/donation/pay", method = RequestMethod.POST)
    public void payForOption(@RequestBody DonationDTO donationDTO) {
        helpOnNeedies.payForOption(donationDTO.getNeedy(), donationDTO.getOption());
    }

}
