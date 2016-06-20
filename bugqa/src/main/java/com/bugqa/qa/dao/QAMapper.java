package com.bugqa.qa.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bugqa.qa.model.dto.BaseArgValue;
import com.bugqa.qa.model.dto.BaseQADTO;
import com.bugqa.qa.model.dto.CustomQADTO;
import com.bugqa.qa.model.dto.ExcelQADTO;
import com.bugqa.qa.model.dto.MAI0061ArgValue;
import com.bugqa.qa.model.dto.QA0010ArgValue;
import com.bugqa.qa.model.dto.QA0020ArgValue;
import com.bugqa.qa.model.dto.QA0050ArgValue;
import com.bugqa.qa.model.dto.QA0060ArgValue;
import com.bugqa.qa.model.dto.QADetailDTO;
import com.bugqa.qa.model.dto.QAMyNoticeDTO;
import com.bugqa.qa.model.dto.QAMyWorkDTO;

/**
 * Q&A情报取得DAO
 * 
 * @author zt c.
 *
 */
public interface QAMapper {

	/**
	 * 我的工作列表
	 * 
	 * @param arg
	 * @return 我的工作列表
	 */
	List<QAMyWorkDTO> getQAMyWorkByPage(MAI0061ArgValue arg);

	/**
	 * 我关注的工作列表
	 * 
	 * @param arg
	 * @return 我关注的工作列表
	 */
	List<QAMyNoticeDTO> getQAMyNoticeByPage(MAI0061ArgValue arg);

	/**
	 * 定義済み検索：私が提出したQ&A
	 * 
	 * @return QA情报
	 */
	List<BaseQADTO> baseQASearchflg1ByPage(QA0060ArgValue arg);

	/**
	 * 定義済み検索：私が回答するQ&A
	 * 
	 * @return QA情报
	 */
	List<BaseQADTO> baseQASearchflg2ByPage(QA0060ArgValue arg);

	/**
	 * 定義済み検索：全て未回答のQ&A
	 * 
	 * @return QA情报
	 */
	List<BaseQADTO> baseQASearchflg3ByPage(QA0060ArgValue arg);

	/**
	 * 定義済み検索：全て未承認のQ&A
	 * 
	 * @return QA情报
	 */
	List<BaseQADTO> baseQASearchflg4ByPage(QA0060ArgValue arg);

	/**
	 * 定義済み検索：全てのQ&A
	 * 
	 * @return QA情报
	 */
	List<BaseQADTO> baseQASearchflg5ByPage(QA0060ArgValue arg);

	/**
	 * 定義済み検索：項目によって
	 * 
	 * @return QA情报
	 */
	List<BaseQADTO> baseQASearchflg6ByPage(QA0060ArgValue arg);

	/**
	 * 自定义QA检索
	 * 
	 * @param arg
	 *            自定义检索条件
	 * @return 检索QA结果
	 */
	List<CustomQADTO> customQASearchByPage(QA0050ArgValue arg);

	/**
	 * excel QA0060导出QA情报
	 * 
	 * @return
	 */
	List<ExcelQADTO> excelExportQA0060(BaseArgValue arg);

	/**
	 * excel QA0050导出QA情报
	 * 
	 * @return
	 */
	List<ExcelQADTO> excelExportQA0050(BaseArgValue arg);

	/**
	 * 插入QA
	 * 
	 * @param qa
	 */
	int insertQA(QA0010ArgValue arg);

	/**
	 * 更改关联QA状态
	 * 
	 * @param arg
	 * 
	 */
	int updateQAInfo(QA0010ArgValue arg);

	/**
	 * QA履歴情报取得。
	 * 
	 * @param projectId
	 *            项目ID
	 * @param qaNo
	 *            QA番号
	 * @param serialNum
	 *            连番
	 * @return
	 */
	QADetailDTO getQAInfo(@Param("projectId") String projectId, @Param("qaNo") String qaNo,
			@Param("serialNum") String serialNum);

	/**
	 * 数据加锁处理 获得更新时间
	 * 
	 * @param projectId
	 *            项目ID
	 * @param qaNo
	 *            QA番号
	 * @return
	 */
	Date getUpdateTime(@Param("projectId") String projectId, @Param("qaNo") String qaNo);

	/**
	 * 数据加锁处理
	 * 
	 * @return 更新时间
	 */
	Date getQANoLock(QA0020ArgValue arg);

	/**
	 * QA保存処理
	 * 
	 * @param arg
	 */
	int saveQA(QA0020ArgValue arg);

	/**
	 * QA状态修改処理
	 * 
	 * @param arg
	 * @return
	 */
	int changeQAState(QA0020ArgValue arg);

	/**
	 * 承認関連Q&A情報
	 * 
	 * @param arg
	 * @return
	 */
	int acceptRelationQA(QA0020ArgValue arg);

	/**
	 * 関連Q&A番号
	 * 
	 * @param arg
	 * @return
	 */
	Map<String, Object> getRelationQANo(QA0020ArgValue arg);

	/**
	 * 数据加锁
	 * 
	 * @param arg
	 * @return
	 */
	String lockQAByQaNo(QA0020ArgValue arg);

}