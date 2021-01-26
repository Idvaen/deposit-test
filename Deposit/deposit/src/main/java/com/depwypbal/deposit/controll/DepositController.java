package com.depwypbal.deposit.controll;

import com.depwypbal.deposit.model.Deposit;
import com.depwypbal.deposit.repo.DepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DepositController {
    @Autowired
    private DepositRepository depositRepository;

    @GetMapping("/deposit")
    public String depositMain(Model model){
        Iterable<Deposit> deposits = depositRepository.findAll();
        model.addAttribute("deposits", deposits);
        return "deposit-main";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam long dep, Model model){
        Deposit deposit = new Deposit(dep);
        deposit.setBalans(dep);
//        for(int i=0;i<1;i++){
//            if (deposit.getBalans()==0){
//                deposit.setBalans(dep);}
//            else
//                deposit.setBalans(deposit.getDeposit()+deposit.getBalans());
//        }
//        for(int i=0;i<deposit.getId();i++){
//            if (deposit.getBalans()==0){
//                 deposit.setBalans(dep);}
//            else
//                deposit.setBalans(deposit.getDeposit()+deposit.getBalans());
//        }
//        model.addAttribute(sum);
//        model.addAttribute(dep);
//        model.addAttribute(bal);
        depositRepository.save(deposit);
        return "redirect:/balans";
    }

    @GetMapping("/balans")
    public String viewBalans(Model model){
        Iterable<Deposit> deposits = depositRepository.findAll();
        model.addAttribute("deposits", deposits);
        return "balans";
    }
//    @PostMapping("/balans")
//    public String balansSum(@PathVariable(value = "id") long id, long bal, Model model){
//        Deposit deposit = depositRepository.findById(id).orElseThrow();
//        Deposit balance = new Deposit();
//        ArrayList<Deposit>  res = new ArrayList<>();
//        for ( int i=0; i<res.toArray().length;i++)
//        {
//            balance.setBalans(bal);
//        }
//        return "redirect:/balans";
//    }

//    @PostMapping("/balans")
//    public String sumBalans(Model model){
//
//        return "";
//    }
    @GetMapping("/wyplata")
    public String wyplata(Model model) {
        Iterable<Deposit> deposits = depositRepository.findAll();
        model.addAttribute("deposits", deposits);
        return "wyplata-main";
    }

    @PostMapping("/wyplata/{id}")
    public String wyplata(@PathVariable(value = "id") long id, Model model) {
        Deposit deposit = depositRepository.findById(id).orElseThrow();
        depositRepository.delete(deposit);
        return "redirect:/balans";
    }

}
