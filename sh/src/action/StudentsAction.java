package action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
import service.StudentsService;
import service.impl.StudentsServiceImpl;

public class StudentsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private StudentsService studentsService = new StudentsServiceImpl();

	/**
	 * 查找所有学生
	 * 
	 * @return
	 */
	public String query() {
		List<Students> result = studentsService.queryAllStudents();
		if (null != result && result.size() > 0) {
			session.put("students_list", result);
		}
		return "query_success";
	}

	/**
	 * 删除学生
	 * 
	 * @return
	 */
	public String delete() {
		String sid = (String) request.getParameter("sid");
		boolean result = studentsService.deleteStudents(sid);
		if (result) {
			return "delete_success";
		} else {
			return "fail";
		}
	}

	/**
	 * 添加学生
	 * 
	 * @return
	 * @throws ParseException
	 */
	public String add() throws ParseException {
		Students students = new Students();
		students.setSname(request.getParameter("sname"));
		students.setGender(request.getParameter("gender"));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		students.setBirthday(simpleDateFormat.parse(request.getParameter("birthday")));
		students.setAddress(request.getParameter("address"));
		studentsService.addStudents(students);
		return "add_success";
	}

	/**
	 * 显示修改学生信息
	 * 
	 * @return
	 */
	public String modify() {
		String sid = request.getParameter("sid");
		Students students = studentsService.queryStudentsBySid(sid);
		session.put("modify_students", students);
		return "modify_success";
	}

	/**
	 * 保存修改信息
	 * 
	 * @return
	 * @throws ParseException
	 */
	public String save() throws ParseException {
		Students students = new Students();
		students.setSid(request.getParameter("sid"));
		students.setSname(request.getParameter("sname"));
		students.setGender(request.getParameter("gender"));

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		students.setBirthday(simpleDateFormat.parse(request.getParameter("birthday")));
		students.setAddress(request.getParameter("address"));
		studentsService.updateStudents(students);
		return "save_success";
	}
}
