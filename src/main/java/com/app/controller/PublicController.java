package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Donation;
import com.app.model.ListDonatur;
import com.app.model.Payment;
import com.app.service.DonationService;
import com.app.service.DonaturService;
import com.app.service.PaymentService;

@Controller
public class PublicController extends BaseController {
    
    @Autowired
    private DonationService donationService;
    
//    @Autowired
//    private DonationMemberService donationMemberService;
    
    @Autowired
    private DonaturService donaturService;
    
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/donasi")
    public String listDonasi(@RequestParam Long id, Model model) throws Exception {
        model.addAttribute("metaTitle", "Donasi - ProdemyCare");
        Donation donation = donationService.findById(id);
        model.addAttribute("donation", donation);
        List <Payment> payment = paymentService.findAll();
        model.addAttribute("listPayment", payment);
        model.addAttribute("donationId", id);
        List <ListDonatur> donatur = donaturService.findAllById(id);        
        model.addAttribute("listDonatur", donatur);
        return "public/donasi";
    }

    @PostMapping("/donasi")
    public String addDonasi(Model model, HttpServletRequest req) throws Exception {
//        Donation donation = new Donation();
//        donation.setId(Long.parseLong(req.getParameter("donationId")));
        ListDonatur dtr = new ListDonatur();
        dtr.setDonationId(Long.parseLong(req.getParameter("donationId")));
//        dtr.setDonation(donation);
        dtr.setNominal(Long.parseLong(req.getParameter("nominal")));
        dtr.setRekening(Integer.parseInt(req.getParameter("rekening")));
        dtr.setNama(req.getParameter("nama"));
        dtr.setPhone(req.getParameter("noHP"));
        dtr.setDukungan(req.getParameter("dukungan"));
        donaturService.insert(dtr);
        
//        DonationMember dm = new DonationMember();
//        dm.setDonationId(Long.parseLong(req.getParameter("donationId")));
//        dm.setDonaturId(dtr.getId());
//        donationMemberService.save(dm);

        return "redirect:/";
    }

    @GetMapping("/")
    public String home(Model model) throws Exception {
        List<Donation> listDonation = donationService.homeFindAll();
        model.addAttribute("listDonation", listDonation);
        
        model.addAttribute("metaTitle", "Home - ProdemyCare");
        return "public/index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("metaTitle", "About - ProdemyCare");
        return "public/about";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("metaTitle", "Login - ProdemyCare");
        return "public/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("metaTitle", "register - ProdemyCare");
        return "public/register";
    }

    @GetMapping("/admin")
    public String adminHome(Model model, Authentication auth) {
        if (this.hasRole("ROLE_ADMIN", auth))
            return "admin/index";
        if (this.hasRole("ROLE_ADMIN", auth))
            return "redirect:/accessdenied";

        return "admin";
    }

    @GetMapping("/user")
    public String userHome(Model model, Authentication auth) {
        if (this.hasRole("ROLE_USER", auth))
            return "user/index";
        if (this.hasRole("ROLE_USER", auth))
            return "redirect:/accessdenied";

        return "user";
    }

    @GetMapping("/accessdenied")
    public String accessdenied(Model model, Authentication auth) {
        return "accessdenied";
    }
}
