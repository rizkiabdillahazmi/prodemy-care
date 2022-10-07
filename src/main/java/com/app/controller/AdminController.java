package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Donation;
import com.app.model.Event;
import com.app.model.Payment;
import com.app.service.DonationService;
import com.app.service.EventService;
import com.app.service.PaymentService;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("metaTitle", "Dashboard - Admin");
        return "admin/index";
    }

    @GetMapping("/payment")
    public String getPayment(Model model) throws Exception {
        List<Payment> list = paymentService.findAll();
        model.addAttribute("metaTitle", "Rekening - Admin");
        model.addAttribute("list", list);
        return "admin/payment";
    }

    @GetMapping("/paymentEdit")
    public String showUpdateForm(@RequestParam int id, Model model) throws Exception {
        Payment pay = paymentService.findById(id);
        model.addAttribute("metaTitle", "Edit Rekening - Admin");
        model.addAttribute("pay", pay);
        return "admin/paymentEdit";
    }

    @PostMapping("/paymentUpdate/{id}")
    public String updateForm(Model model, HttpServletRequest req, @RequestParam int id) throws Exception {
        Payment pay = paymentService.findById(id);
        pay.setId(Integer.parseInt(req.getParameter("id")));
        pay.setName(req.getParameter("name"));
        pay.setRekening(req.getParameter("rekening"));
        paymentService.update(pay);

        return "redirect:/admin/payment";
    }

    @GetMapping("/paymentAdd")
    public String viewAddPayment(Model model) throws Exception {
        return "admin/paymentAdd";
    }

    @PostMapping("/paymentAdd")
    public String addPayment(Model model, HttpServletRequest req) throws Exception {
        Payment pay = new Payment();
        pay.setName(req.getParameter("name"));
        pay.setRekening(req.getParameter("rekening"));
        paymentService.insert(pay);

        return "redirect:/admin/payment";
    }

    @GetMapping("/paymentDelete")
    public String deletePayment(@RequestParam int id) throws Exception {
        paymentService.deleteById(id);

        return "redirect:/admin/payment";
    }

    @Autowired
    private EventService eventService;

    @GetMapping("/kategori")
    public String getKategori(Model model) throws Exception {
        List<Event> event = eventService.findAll();
        model.addAttribute("list", event);
        return "admin/kategori";
    }

    @GetMapping("/kategoriEdit")
    public String showUpdateFormKategori(@RequestParam int id, Model model) throws Exception {
        Event event = eventService.findById(id);
        model.addAttribute("event", event);

        return "admin/kategoriEdit";
    }

    @PostMapping("/kategoriUpdate/{id}")
    public String updateKategori(Model model, HttpServletRequest req, @RequestParam int id) throws Exception {
        Event event = eventService.findById(id);
        event.setName(req.getParameter("name"));
        eventService.update(event);

        return "redirect:/admincoba/kategori";
    }

    @GetMapping("/kategoriAdd")
    public String viewAddEvent(Model model) throws Exception {
        return "admin/kategoriAdd";
    }

    @PostMapping("/kategoriAdd")
    public String addEvent(Model model, HttpServletRequest req) throws Exception {
        Event event = new Event();
        event.setName(req.getParameter("name"));
        eventService.insert(event);

        return "redirect:/admincoba/kategori";
    }

    @GetMapping("/kategoriDelete")
    public String deleteEvent(@RequestParam int id) throws Exception {
        eventService.deleteById(id);

        return "redirect:/admincoba/payment";
    }

    @Autowired
    private DonationService donationService;

    @GetMapping("/donasi")
    public String getDonation(Model model) throws Exception {
        List<Donation> donation = donationService.findAll();
        model.addAttribute("list", donation);
        return "admin/donasi";
    }

    @GetMapping("/donationUpdate")
    public String updateDonation(@RequestParam int id, int status) throws Exception {
        Donation donasi = donationService.findById(id);
        donasi.setStatus(status);
        donationService.update(donasi);

        return "redirect:/admin/donasi";
    }
}