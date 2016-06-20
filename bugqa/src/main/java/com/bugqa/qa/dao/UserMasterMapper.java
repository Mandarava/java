package com.bugqa.qa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bugqa.qa.model.dto.PRO0041ArgValue;
import com.bugqa.qa.model.dto.PRO0050ArgValue;
import com.bugqa.qa.model.dto.Page;
import com.bugqa.qa.model.dto.USE0010ArgValue;
import com.bugqa.qa.model.dto.USE0020ArgValue;
import com.bugqa.qa.model.dto.USE0031ArgValue;
import com.bugqa.qa.model.dto.USE0032ArgValue;
import com.bugqa.qa.model.po.UserMaster;

public interface UserMasterMapper {

	/**
	 * 验证登录信息
	 * 
	 * @param userId
	 *            用户名
	 * @param pwd
	 *            密码
	 * @return
	 */
	int validLogin(@Param("userId") String userId, @Param("pwd") String pwd);

	/**
	 * 用户信息获得
	 * 
	 * @param userInfo
	 *            用户ID账号
	 * @return
	 */
	UserMaster getUserInfo(String userInfo);

	/**
	 * USE0010 查询所有用户
	 * 
	 * @param deleteFlg
	 *            删除标记
	 * @param userName
	 *            用户名
	 * @param userId
	 *            用户ID
	 * @param page
	 *            分页信息
	 * @return
	 */
	List<UserMaster> queryUserByPage(@Param("arg") USE0010ArgValue arg, @Param("page") Page page);

	List<UserMaster> searchUserByPage(@Param("arg") USE0010ArgValue arg, @Param("page") Page page);

	/**
	 * QA0070 メンバーの取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return メンバー
	 */
	List<UserMaster> getMemberInfo(String projectId);

	/**
	 * QA0010提出者を取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return
	 */
	List<UserMaster> getQuestioner(String projectId);

	/**
	 * QA0010回答者取得
	 * 
	 * @param projectId
	 *            项目ID
	 * @return
	 */
	List<UserMaster> getAnswerer(@Param("projectId") String projectId,
			@Param("workType") String workType, @Param("companyFlg") String companyFlg);

	/**
	 * 插入ユーサー信息
	 */
	void newUser(USE0020ArgValue arg);

	/**
	 * ユーサーID存在性的チェック
	 */
	String userIdCheck(String userId);

	/**
	 * 判断ユーサー信息是否管理员
	 */
	String userPrevlCheck(String userId);

	/**
	 * 取得当前ユーザー信息
	 * 
	 * @return
	 */
	List<UserMaster> userMsg(String userId);

	/**
	 * 更新ユーザー信息
	 */
	void updateUser(USE0031ArgValue arg);

	/**
	 * 更新ユーザー信息
	 */
	void updateUserpart(USE0032ArgValue arg);

	/**
	 * 初始化リスト部 取得ユーザー信息
	 * 
	 * @param map
	 * @return
	 */
	List<UserMaster> userMsgSelectByPage(@Param("arg") PRO0041ArgValue arg,
			@Param("page") Page page);

	List<UserMaster> getDeveloper(String projectId);

	List<UserMaster> getVerifier(String projectId);

	List<UserMaster> getPlnVerifier(String projectId);

	List<UserMaster> getDetecto(String projectId);

	List<UserMaster> getBugMember(String projectId);

	/**
	 * 函数名 与mapping中的id相同
	 * 
	 * @param projectId
	 * @return
	 */
	List<UserMaster> getBugPlnverifier(String projectId);

	/**
	 * 初始化リスト部 取得ユーザー信息
	 * 
	 * @param map
	 * @return
	 */
	List<UserMaster> listUserMsgByPage(@Param("arg") PRO0050ArgValue arg, @Param("page") Page page);

	/**
	 * 取得当前用户所属部门
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMaster> userCustomerCode(String userId);

	/**
	 * ユーザー名を取得
	 * 
	 * @param projectId
	 * @return
	 */
	List<UserMaster> getUserName(String projectId);

	/**
	 * 
	 * @param userId
	 * @return
	 */
	void deleteUser(String userId);

	/**
	 * 普通用户信息
	 * 
	 * @param userId
	 * @return
	 */
	List<UserMaster> userMsgCom(String userId);

	/**
	 * 取得项目经理信息
	 * 
	 * @param projectId
	 * @return
	 */
	List<UserMaster> projectManagerMsg(String projectId);

}