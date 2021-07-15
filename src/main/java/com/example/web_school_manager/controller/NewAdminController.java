package com.example.web_school_manager.controller;

import com.example.web_school_manager.bean.TgUserTable;
import com.example.web_school_manager.dao.service.AdminService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/admin")
public class NewAdminController {

    private final AdminService adminService;

    @Autowired
    public NewAdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    @GetMapping("/adminMenu")
    public String adminPageMenu() {
        return "adminMenu";
    }

    @RequestMapping("/schedule")
    public @ResponseBody
    String schedulePage() {
        return "https://calendar.google.com/calendar/embed";
    }

    @GetMapping("/userBlock")
    public List<TgUserTable> blackListPage() {
        return adminService.findAllBlockUser();
    }

    @GetMapping("/findUserForBlock")
    public Optional<TgUserTable> searchUserForBlock(String userName) {
        return adminService.searchTgUserForBlockList(userName);
    }

    @GetMapping("/blockUserDelete" + "/{id}")
    public Optional<TgUserTable> deleteTgUserById(@PathVariable("id") Long id) {
        Optional<TgUserTable> tgUserTable = adminService.findBlockUserById(id);
        return tgUserTable;
    }

    @DeleteMapping("/blockUserDelete" + "/{id}")
    public String deleteAndReturnToBlackList(@PathVariable("id") Long id) throws Exception {
        adminService.deleteUserById(id);
        return "redirect:/userBlock";
    }

    @GetMapping("/blockUserUpdate" + "/{id}")
    public Optional<TgUserTable> updateStatusBlock(@PathVariable("id") Long id) {
        Optional<TgUserTable> tgUserTable = adminService.findBlockUserById(id);
        return tgUserTable;
    }

    @PostMapping("/blockUserUpdate" + "/{id}")
    public String updateStatusBlockUser(@PathVariable("id") Long id,
                                             @RequestParam(value = "blockUser") /* defaultValue = "false"*/  Boolean blockUser){
        adminService.updateBlockStatusUser(id, blockUser);

        return "redirect:/userBlock";
    }

//    @PostMapping("/blockUserUpdateUpdate" + "/{id}")
//    public TgUserTable updateStatusBlockUserUser(@PathVariable("id") Long id,
//                                        @RequestParam(value = "blockUser") Boolean blockUser){
//        TgUserTable tgUserTableUser = adminService.updateBlockStatusUser(id, blockUser);
//        return tgUserTableUser;
//    }



//    @PostMapping(value = "updateBlockUser" + "/{id}")
//    public ModelAndView updateStatusBlockUser(@PathVariable(name = "id") Long id,
//                                              @RequestParam(value = "blockUser") Boolean blockUser){
//        ModelAndView modelAndView = new ModelAndView("/updateBlockStatus.html");
//        adminService.updateBlockStatusUser(id, blockUser);
//        modelAndView.setViewName("redirect:/admin/userBlock");
//        return modelAndView;
//    }

    /*
    @PutMapping(value = "/{personId}")
    public ResponseEntity<Person> updatePerson(@RequestBody @Valid Person person,
            @PathVariable("personId") Long personId) throws EntityNotFoundException {
        Optional<Person> p = personRepository.findById(personId);
        if (!p.isPresent())
            throw new EntityNotFoundException("id-" + personId);
        return ResponseEntity.ok().body(personRepository.save(person));
    }
     */

//    @DeleteMapping(value = "/{personId}")
//    public ResponseEntity<Person> deletePerson(@PathVariable("personId") Long personId)
//            throws EntityNotFoundException {
//        Optional<Person> p = personRepository.findById(personId);
//        if (!p.isPresent())
//            throw new EntityNotFoundException("id-" + personId);
//        personRepository.deleteById(personId);
//        return ResponseEntity.ok().body(p.get());
//    }

//@GetMapping(value = Http.DELETE_PRODUCT + "/{id}")
//public String deleteProducts(@PathVariable(name = "id") Long id) {
//    productService.deleteById(id);
//    return Pages.REDIRECT + Pages.HOME;



//    @PostMapping("/addStudent")
//    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
//        studentDto.setName("max");
//        return studentDto;
//    }


}
