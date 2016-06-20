package service;

import java.util.List;

import entity.Students;

public interface StudentsService {

	// 查询所有学生资料
	public List<Students> queryAllStudents();

	// 根据学生编号查询学生资料
	public Students queryStudentsBySid(String sid);

	// 添加学生资料
	public boolean addStudents(Students student);

	// 更新学生资料
	public boolean updateStudents(Students student);

	// 删除学生资料
	public boolean deleteStudents(String sid);
}
