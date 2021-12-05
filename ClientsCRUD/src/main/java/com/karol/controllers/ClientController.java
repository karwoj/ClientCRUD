package com.karol.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;   
import com.karol.beans.Client;  
import com.karol.dao.ClientDao;  

@Controller  
public class ClientController {  
    @Autowired  
    ClientDao dao;
      
    @RequestMapping("/addClient")  
    public String showform(Model m){  
    	m.addAttribute("command", new Client());
    	return "addClient"; 
    }  

    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cli") Client cli){  
        dao.save(cli);  
        return "redirect:/viewAllClients"; 
    }
    
    @RequestMapping("/viewAllClients")  
    public String viewemp(Model m){  
        List<Client> list=dao.getClients();  
        m.addAttribute("list",list);
        return "viewAllClients";  
    } 
    
    @RequestMapping(value="/viewclient/{id}")    
    public String edit(@PathVariable int id, Model m){   
        Client cli=dao.getClientById(id);    
        m.addAttribute("command",cli);  
        return "viewclient";    
    }    
    
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("cli") Client cli){  
        dao.update(cli);  
        return "redirect:/viewAllClients";  
    }  
 
    @RequestMapping(value="/deletecli/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewAllClients";  
    } 
    
}  