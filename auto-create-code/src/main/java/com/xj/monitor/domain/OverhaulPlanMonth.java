package com.xj.monitor.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Herman
 * @since 2024-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_overhaul_plan_month")
public class OverhaulPlanMonth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String overhaulNo;

    /**
     * 状态 (新增，变更，删除)
     */
    private Integer status;

    /**
     * 巡维中心名称
     */
    private String patrolcenterName;

    /**
     * 巡维中心code
     */
    private String patrolcenterCode;

    /**
     * 调管范围 名称
     */
    private String dispatchManageRangeName;

    /**
     * 调管范围code
     */
    private String dispatchManageRangeCode;

    /**
     * 电压等级
     */
    private Integer voltage;

    /**
     * 厂站名称
     */
    private String substationName;

    /**
     * 厂站名称code
     */
    private String substationCode;

    /**
     * 一次设备名称
     */
    private String primDevName;

    /**
     * 一次设备code
     */
    private String primDevCode;

    /**
     * 二次装置名称
     */
    private String secDevName;

    /**
     * 二次装置code
     */
    private String secDevCode;

    /**
     * 二次装置类型
     */
    private Integer secDevType;

    /**
     * 二次装置型号
     */
    private String secDevModel;

    /**
     * 工作内容
     */
    private String workContent;

    /**
     * 状态评价分数
     */
    private Double conditionEvaluationScore;

    /**
     * 是否需要停电 ( 1:不停电；2:停电；0：未知 )
     */
    private Integer powerCutFlag;

    /**
     * 计划开工日期
     */
    private LocalDate planStartDate;

    /**
     * 计划完工时间
     */
    private LocalDate planEndDate;

    /**
     * 任务来源
     */
    private Integer taskSourceOrigin;

    /**
     * 原因说明
     */
    private String reasonDescription;

    /**
     * 实际开工日期
     */
    private LocalDate realStartDate;

    /**
     * 实际完工日期
     */
    private LocalDateTime realEndDate;

    /**
     * 是否完成
     */
    private Integer finishFlag;

    /**
     * 未完成原因
     */
    private String unfinishedReason;

    /**
     * 未完成任务处理
     */
    private String unfinishedTaskProcess;

    /**
     * 变更后工作时间
     */
    private LocalDateTime afterChangeWorkTime;

    /**
     * 检修申请验号
     */
    private String overhaulReqNo;

    /**
     * 检修申请内容
     */
    private String overhaulReqContent;

    /**
     * 编制状态
     */
    private Integer editStatus;

    /**
     * 执行状态
     */
    private Integer executeStatus;

    /**
     * 计划类型(year:年计划；month:月计划)
     */
    private String planType;

    /**
     * 计划年月
     */
    private String planYearMonth;

    /**
     * 插入时间
     */
    private LocalDateTime insertTime;

    /**
     * 记录插入时间
     */
    private LocalDateTime recordInsertTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime recordUpdateTime;

    /**
     * 创建类型(自动执行:auto或者手动添加manual)
     */
    private String creatFlag;

    /**
     * 同一装置最早计划处理时间
     */
    private LocalDateTime planProcessTime;

    /**
     * 逻辑删除 （0未删除，1 已经删除）
     */
    @TableLogic
    private Integer deleted;


}
