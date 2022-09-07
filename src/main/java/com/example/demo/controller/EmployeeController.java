package com.example.demo.controller;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Project;
import com.example.demo.model.Qualification;
import com.example.demo.model.Task;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProjectService;
import com.example.demo.service.QualificationService;
import com.example.demo.service.TaskService;
import lombok.extern.log4j.Log4j2;

@RestController
@ComponentScan("com.employee.demo.service")
@ComponentScan("com.employee.demo.service.ProjectService")
@ComponentScan("com.employee.demo.service.TaskService")
@Log4j2
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectService projectService;

	@Autowired
	TaskService taskService;

	@Autowired
	QualificationService qualificationService;

	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/")
	public ModelAndView home() {
		log.info("Requesting the model: home page ");
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping("/employee")
	public ModelAndView viewEmployee() {
		log.info("Requesting the model: employee + List of the employees ");
		ModelAndView mav = new ModelAndView("Employee");
		List<Employee> employees = employeeService.findAll();
		mav.addObject("employees", employees);
		log.info("Displaying the employee page ");
		return mav;
	}

	@GetMapping("/project")
	public ModelAndView viewProject() {
		log.info("Requesting the model: project page + List of the projects");
		ModelAndView mav = new ModelAndView("Project");
		List<Project> projects = projectService.findAll();
		mav.addObject("projects", projects);
		log.info("Displaying the project page ");
		return mav;
	}

	@GetMapping("/task")
	public ModelAndView viewTask() {
		log.info("Requesting the model: task page + List of the tasks");
		ModelAndView mav = new ModelAndView("Task");
		List<Task> tasks = taskService.findAll();
		mav.addObject("tasks", tasks);
		log.info("Displaying the task page ");
		return mav;
	}

	@GetMapping("/qualification")
	public ModelAndView viewQualification() {
		log.info("Requesting the model: qualification page + List of the qualifications");
		ModelAndView mav = new ModelAndView("Qualification");
		List<Qualification> qualifications = qualificationService.findAll();
		mav.addObject("qualifications", qualifications);
		log.info("Displaying the qualification page ");
		return mav;
	}

	@GetMapping("/department")
	public ModelAndView viewDepartment() {
		log.info("Requesting the model: department page + List of the departments");
		ModelAndView mav = new ModelAndView("Department");
		List<Department> departments = departmentService.findAll();
		mav.addObject("departments", departments);
		log.info("Displaying the department page ");
		return mav;
	}

	@GetMapping(path = "/project-employee/{id}")
	public ModelAndView findProjectsFromEmployees(@PathVariable("id") int id) {
		log.info("Requesting the model: project page + List of the projects for the employee");
		ModelAndView mav = new ModelAndView("Project");
		Employee employee = employeeService.findById(id);
		List<Project> projects = employee.getProjects();
		mav.addObject("projects", projects);
		log.info("Displaying the project page with the projects for the employee");
		return mav;
	}

	@GetMapping(path = "/task-employee/{id}")
	public ModelAndView findTasksFromEmployees(@PathVariable("id") int id) {
		log.info("Requesting the model: task page + List of the tasks for the employee");
		ModelAndView mav = new ModelAndView("Task");
		Employee employee = employeeService.findById(id);
		List<Task> tasks = employee.getTasks();
		mav.addObject("tasks", tasks);
		log.info("Displaying the task page with the tasks for the employee");
		return mav;
	}

	@GetMapping(path = "/qualification-employee/{id}")
	public ModelAndView findQualificationsFromEmployees(@PathVariable("id") int id) {
		log.info("Requesting the model: qualification page + List of the qualifications for the employee");
		ModelAndView mav = new ModelAndView("Qualification");
		Employee employee = employeeService.findById(id);
		List<Qualification> qualifications = employee.getQualifications();
		mav.addObject("qualifications", qualifications);
		log.info("Displaying the qualification page with the qualifications for the employee");
		return mav;
	}

	@GetMapping(path = "/employee-task/{taskName}")
	public ModelAndView findEmployeesFromTask(@PathVariable("taskName") String taskName) {
		log.info("Requesting the model: employee page + List of the employees for the task");
		ModelAndView mav = new ModelAndView("Employee");
		Task task = taskService.findById(taskName);
		List<Employee> employees = task.getEmployees();
		mav.addObject("employees", employees);
		log.info("Displaying the employee page with the employees for the task");
		return mav;
	}

	@GetMapping(path = "/employee-department/{depName}")
	public ModelAndView findEmployeesFromDepartment(@PathVariable("depName") String depName) {
		log.info("Requesting the model: employee page + List of the employees for the department");
		ModelAndView mav = new ModelAndView("Employee");
		Department department = departmentService.findById(depName);
		List<Employee> employees = department.getEmployees();
		mav.addObject("employees", employees);
		log.info("Displaying the employee page with the employees for the department");
		return mav;
	}

	@GetMapping(path = "/qualification-task/{taskName}")
	public ModelAndView findQualificationsFromTask(@PathVariable("taskName") String taskName) {
		log.info("Requesting the model: qualification page + List of the qualifications for the task");
		ModelAndView mav = new ModelAndView("Qualification");
		Task task = taskService.findById(taskName);
		List<Qualification> qualifications = task.getQualifications();
		mav.addObject("qualifications", qualifications);
		log.info("Displaying the qualification page with the qualifications for the task");
		return mav;
	}

	@GetMapping(path = "/task-project/{projName}")
	public ModelAndView findTasksFromProject(@PathVariable("projName") String projName) {
		log.info("Requesting the model: task page + List of the tasks for the project");
		ModelAndView mav = new ModelAndView("Task");
		Project project = projectService.findById(projName);
		List<Task> tasks = project.getTasks();
		mav.addObject("tasks", tasks);
		log.info("Displaying the task page with the tasks for the project");
		return mav;
	}

	@GetMapping(path = "/employee/{id}")
	public ModelAndView editEmployee(@PathVariable("id")@Valid  @NotNull @RequestBody int id) {
		log.info("Requesting the model: employee page for editing");
		ModelAndView mav = new ModelAndView("EmployeeEdit");
		log.info("Get the employee by id");
		Employee employee = employeeService.findById(id);
		List<Qualification> qualifications = employee.getQualifications();
		List<Qualification> allQualifications = qualificationService.findAll();
		List<Qualification> newQualifications = allQualifications.stream()
				.filter(str -> qualifications.contains(str) ^ allQualifications.contains(str))
				.collect(Collectors.toList());
		Department department = employee.getDepartment();
		List<Department> allDepartments = departmentService.findAll();
		List<Department> newDepartments = allDepartments;
		if (department != null)
			newDepartments = allDepartments.stream()
					.filter(str -> allDepartments.contains(str) ^ department.equals(str)).collect(Collectors.toList());
		List<Project> projects = employee.getProjects();
		List<Project> allProjects = projectService.findAll();
		List<Project> newProjects = allProjects.stream()
				.filter(str -> projects.contains(str) ^ allProjects.contains(str)).collect(Collectors.toList());
		List<Task> tasks = employee.getTasks();
		List<Task> allTasks = taskService.findAll();
		List<Task> newTasks = allTasks.stream().filter(str -> tasks.contains(str) ^ allTasks.contains(str))
				.collect(Collectors.toList());

		Predicate<Project> manage = project -> project.getManager() == null;
		newProjects = newProjects.stream().filter(manage).collect(Collectors.toList());

		mav.addObject("employee", employee);
		mav.addObject("qualifications", qualifications);
		mav.addObject("newQualifications", newQualifications);
		mav.addObject("selDepartment", department);
		mav.addObject("newDepartments", newDepartments);
		mav.addObject("projects", projects);
		mav.addObject("newProjects", newProjects);
		mav.addObject("tasks", tasks);
		mav.addObject("newTasks", newTasks);
		log.info("Displaying the employee page for editing");
		return mav;
	}

	@GetMapping(path = "/task/{taskName}")
	public ModelAndView editTask(@PathVariable("taskName")@Valid  @NotNull @RequestBody String taskName) {
		log.info("Requesting the model: task page for editing");
		ModelAndView mav = new ModelAndView("TaskEdit");
		log.info("Get the task by the taskName");
		Task task = taskService.findById(taskName);
		List<Employee> employees = task.getEmployees();
		List<Employee> allEmployees = employeeService.findAll();
		List<Employee> newEmployees = allEmployees.stream()
				.filter(str -> employees.contains(str) ^ allEmployees.contains(str)).collect(Collectors.toList());
		Project project = task.getProject();
		List<Project> allProjects = projectService.findAll();
		List<Project> newProjects = allProjects;
		if (project != null)
			allProjects.stream().filter(str -> project.equals(str) ^ allProjects.contains(str))
					.collect(Collectors.toList());
		Task mainTask = task.getMainTask();
		List<Task> allMainTasks = taskService.findAll();
		List<Task> newMainTasks = allMainTasks;
		if (mainTask != null)
			allMainTasks.stream().filter(str -> mainTask.equals(str) ^ allMainTasks.contains(str))
					.collect(Collectors.toList());
		List<Qualification> qualifications = task.getQualifications();
		List<Qualification> allQualifications = qualificationService.findAll();
		List<Qualification> newQualifications = allQualifications.stream()
				.filter(str -> qualifications.contains(str) ^ allQualifications.contains(str))
				.collect(Collectors.toList());

		newMainTasks.remove(task);
		mav.addObject("task", task);
		mav.addObject("employees", employees);
		mav.addObject("newEmployees", newEmployees);
		mav.addObject("project", project);
		mav.addObject("newProjects", newProjects);
		mav.addObject("mainTask", mainTask);
		mav.addObject("newMainTasks", newMainTasks);
		mav.addObject("qualifications", qualifications);
		mav.addObject("newQualifications", newQualifications);
		log.info("Displaying the task page for editing");
		return mav;
	}

	@GetMapping(path = "/project/{projName}")
	public ModelAndView editProject(@PathVariable("projName")@Valid  @NotNull @RequestBody String projName) {
		log.info("Requesting the model: project page for editing");
		ModelAndView mav = new ModelAndView("ProjectEdit");
		log.info("Get the project by projName");
		Project project = projectService.findById(projName);
		List<Task> tasks = project.getTasks();
		List<Task> allTasks = taskService.findAll();
		List<Task> newTasks = allTasks.stream().filter(str -> tasks.contains(str) ^ allTasks.contains(str))
				.collect(Collectors.toList());

		Employee manger = project.getManager();
		List<Employee> allManagers = employeeService.findAll();
		List<Employee> newManagers = allManagers;
		if (manger != null)
			newManagers = allManagers.stream().filter(str -> manger.equals(str) ^ allManagers.contains(str))
					.collect(Collectors.toList());
		mav.addObject("project", project);
		mav.addObject("tasks", tasks);
		mav.addObject("newTasks", newTasks);
		mav.addObject("manager", manger);
		mav.addObject("newManagers", newManagers);
		log.info("Displaying the project page for editing");
		return mav;
	}

	@GetMapping(path = "/department/{depName}")
	public ModelAndView editDepartment(@PathVariable("depName")@Valid  @NotNull @RequestBody String depName) {
		log.info("Requesting the model: department page for editing");
		ModelAndView mav = new ModelAndView("DepartmentEdit");
		log.info("Get the department by depName");
		Department department = departmentService.findById(depName);
		List<Employee> employees = department.getEmployees();
		List<Employee> allEmployees = employeeService.findAll();
		List<Employee> newEmployees = allEmployees.stream()
				.filter(str -> employees.contains(str) ^ allEmployees.contains(str)).collect(Collectors.toList());
		mav.addObject("department", department);
		mav.addObject("employees", employees);
		mav.addObject("newEmployees", newEmployees);
		log.info("Displaying the department page for editing");
		return mav;
	}

	@PostMapping("/employee")
	public ModelAndView saveEmployee(@ModelAttribute("Employee")@Valid  @NotNull @RequestBody Employee employee) {
		log.info("Requesting the save method for saving the employee");
		employeeService.save(employee);
		ModelAndView mav = new ModelAndView("Employee");
		List<Employee> employees = employeeService.findAll();
		mav.addObject("employees", employees);
		log.info("Displaying the employee page");
		return mav;
	}
	@PostMapping("/employee/delete/{id}")
	public ModelAndView saveEmployee2(@ModelAttribute("Employee")@Valid  @NotNull @RequestBody Employee employee) {
		log.info("Requesting the save method for saving that the employee is deleted");
		employeeService.save(employee);
		ModelAndView mav = new ModelAndView("Employee");
		List<Employee> employees = employeeService.findAll();
		mav.addObject("employees", employees);
		log.info("Displaying the employee page");
		return mav;
	}

	@PostMapping("/department")
	public ModelAndView saveDepartment(@ModelAttribute("Department")@Valid  @NotNull @RequestBody Department department) {
		log.info("Requesting the save method for saving the department after editing");
		departmentService.save(department);
		ModelAndView mav = new ModelAndView("Department");
		List<Department> departments = departmentService.findAll();
		mav.addObject("departments", departments);
		log.info("Displaying the department page");
		return mav;
	}
	@PostMapping("/department/insertion")
	public ModelAndView saveDepartment2(@ModelAttribute("Department")@Valid  @NotNull @RequestBody Department department) {
		log.info("Requesting the save method for saving the department after insertion");
		departmentService.save(department);
		ModelAndView mav = new ModelAndView("Department");
		List<Department> departments = departmentService.findAll();
		mav.addObject("departments", departments);
		log.info("Displaying the department page");
		return mav;
	}

	@PostMapping("/project")
	public ModelAndView saveProject(@ModelAttribute("Project")@Valid  @NotNull @RequestBody Project project) {
		log.info("Requesting the save method for saving the project after editing");
		projectService.save(project);
		ModelAndView mav = new ModelAndView("Project");
		List<Project> projects = projectService.findAll();
		mav.addObject("projects", projects);
		log.info("Displaying the project page");
		return mav;
	}
	@PostMapping("/project/insertion")
	public ModelAndView saveProject2(@ModelAttribute("Project")@Valid  @NotNull @RequestBody Project project) {
		log.info("Requesting the save method for saving the project after insertion");
		projectService.save(project);
		ModelAndView mav = new ModelAndView("Project");
		List<Project> projects = projectService.findAll();
		mav.addObject("projects", projects);
		log.info("Displaying the project page");
		return mav;
	}

	@PostMapping("/task")
	public ModelAndView saveTask(@ModelAttribute("Task")@Valid  @NotNull @RequestBody Task task) {
		log.info("Requesting the save method for saving the task after editing");
		taskService.save(task);
		ModelAndView mav = new ModelAndView("Task");
		List<Task> tasks = taskService.findAll();
		mav.addObject("tasks", tasks);
		log.info("Displaying the task page");
		return mav;
	}
	@PostMapping("/task/insertion")
	public ModelAndView saveTask2(@ModelAttribute("Task")@Valid  @NotNull @RequestBody Task task) {
		log.info("Requesting the save method for saving the task after insertion");
		taskService.save(task);
		ModelAndView mav = new ModelAndView("Task");
		List<Task> tasks = taskService.findAll();
		mav.addObject("tasks", tasks);
		log.info("Displaying the task page");
		return mav;
	}

	@PostMapping("/qualification")
	public ModelAndView saveQualification( @ModelAttribute("Qualification")@Valid  @NotNull @RequestBody Qualification qualification) {
		log.info("Requesting the save method for saving the qualification after editing");
		qualificationService.save(qualification);
		ModelAndView mav = new ModelAndView("Qualification");
		List<Qualification> qualifications = qualificationService.findAll();
		mav.addObject("qualifications", qualifications);
		log.info("Displaying the qualification page");
		return mav;
	}
	@PostMapping("/qualification/insertion")
	public ModelAndView saveQualification2( @ModelAttribute("Qualification")@Valid  @NotNull @RequestBody Qualification qualification) {
		log.info("Requesting the save method for saving the qualification after insertion");
		qualificationService.save(qualification);
		ModelAndView mav = new ModelAndView("Qualification");
		List<Qualification> qualifications = qualificationService.findAll();
		mav.addObject("qualifications", qualifications);
		log.info("Displaying the qualification page");
		return mav;
	}

	@GetMapping(path = "/employee/delete/{id}")
	public ModelAndView DeleteEmployee(@PathVariable("id") int id) {
		log.info("Requesting the delete method for deleting the employee by id");
		employeeService.delete(id);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping(path = "/department/delete/{depName}")
	public ModelAndView DeleteDepartment(@PathVariable("depName") String depName) {
		log.info("Requesting the delete method for deleting the department by depName");
		departmentService.delete(depName);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping(path = "/task/delete/{taskName}")
	public ModelAndView DeleteTask(@PathVariable("taskName") String taskName) {
		log.info("Requesting the delete method for deleting the task by taskName");
		taskService.delete(taskName);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping(path = "/qualification/delete/{qualificationName}")
	public ModelAndView DeleteQualification(@PathVariable("qualificationName") String qualificationName) {
		log.info("Requesting the delete method for deleting the qualification by qualificationName");
		qualificationService.delete(qualificationName);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping(path = "/project/delete/{projName}")
	public ModelAndView DeleteProject(@PathVariable("projName") String projName) {
		log.info("Requesting the delete method for deleting the project by projName");
		projectService.delete(projName);
		ModelAndView mav = new ModelAndView("homePage");
		log.info("Displaying the home page ");
		return mav;
	}

	@GetMapping("/employee/insertion")
	public ModelAndView addEmployee() {
		log.info("Requesting the model: employee page for inserting new employee");
		ModelAndView mav = new ModelAndView("EmployeeEdit");
		mav.addObject("employee", new Employee());
		List<Qualification> allQualifications = qualificationService.findAll();
		List<Department> allDepartments = departmentService.findAll();
		List<Project> allProjects = projectService.findAll();
		List<Task> allTasks = taskService.findAll();
		Predicate<Project> manage = project -> project.getManager() == null;
		allProjects = allProjects.stream().filter(manage).collect(Collectors.toList());
		mav.addObject("newQualifications", allQualifications);
		mav.addObject("newDepartments", allDepartments);
		mav.addObject("newProjects", allProjects);
		mav.addObject("newTasks", allTasks);
		log.info("Displaying the employee page");
		return mav;
	}

	@GetMapping("/project/insertion")
	public ModelAndView addProject() {
		log.info("Requesting the model: project page for inserting new project");
		ModelAndView mav = new ModelAndView("ProjectAdd");
		mav.addObject("project", new Project());
		List<Task> allTasks = taskService.findAll();
		List<Employee> allManagers = employeeService.findAll();
		mav.addObject("newTasks", allTasks);
		mav.addObject("newManagers", allManagers);
		log.info("Displaying the project page");
		return mav;
	}

	@GetMapping("/department/insertion")
	public ModelAndView addDepatment() {
		log.info("Requesting the model: department page for inserting new department");
		ModelAndView mav = new ModelAndView("DepartmentAdd");
		mav.addObject("department", new Department());
		List<Employee> allEmployees = employeeService.findAll();
		mav.addObject("newEmployees", allEmployees);
		log.info("Displaying the department page");
		return mav;
	}

	@GetMapping("/task/insertion")
	public ModelAndView addTask() {
		log.info("Requesting the model: task page for inserting new task");
		ModelAndView mav = new ModelAndView("TaskAdd");
		mav.addObject("task", new Task());
		List<Employee> allEmployees = employeeService.findAll();
		List<Project> allProjects = projectService.findAll();
		List<Task> allMainTasks = taskService.findAll();
		List<Qualification> allQualifications = qualificationService.findAll();

		mav.addObject("newEmployees", allEmployees);
		mav.addObject("newProjects", allProjects);
		mav.addObject("newMainTasks", allMainTasks);
		mav.addObject("newQualifications", allQualifications);
		log.info("Displaying the task page");
		return mav;
	}

	@GetMapping("/qualification/insertion")
	public ModelAndView addQualification() {
		log.info("Requesting the model: qualification page for inserting new qualification");
		ModelAndView mav = new ModelAndView("QualificationAdd");
		mav.addObject("qualification", new Qualification());
		log.info("Displaying the qualification page");
		return mav;
	}

}
