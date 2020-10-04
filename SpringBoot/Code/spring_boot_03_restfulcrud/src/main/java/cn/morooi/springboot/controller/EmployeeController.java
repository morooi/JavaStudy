package cn.morooi.springboot.controller;

import cn.morooi.springboot.dao.DepartmentDao;
import cn.morooi.springboot.dao.EmployeeDao;
import cn.morooi.springboot.entities.Department;
import cn.morooi.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();

        // 放在请求域中
        model.addAttribute("emps", employees);

        // thymeleaf 默认会拼串
        // classpath:/templates/xxx.html
        return "emp/list";
    }

    // 来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到添加页面, 查出所有部门, 在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    // 员工添加
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定, 要求请求参数的名字和 javabean 入参的对象属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        System.out.println(employee);
        // 保存员工
        employeeDao.save(employee);
        // 重定向 / 代表当前项目路径
        return "redirect:/emps";
    }

    // 来到修改页面, 查出当前员工, 在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        // 查出所有部门, 在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        // 回到修改页面(add 是一个修改添加二合一的页面)
        return "emp/add";
    }

    // 员工修改, 需要员工 id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee) {
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
