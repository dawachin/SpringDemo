package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * スケジュール
 * <BR>
 * DB:TSchedule
 */
@ApiModel(value = "スケジュール情報")
@Entity
@Table(name = "T_SCHEDULE")
public class TSchedule {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Timestamp updateTime;

    @Column(nullable = false, columnDefinition = "0")
    private Integer deleteFlag;

    @Column
    private String location;

    @Column
    private Time endTime;

    @Column
    private Time startTime;

    @Column
    private Date endDate;

    @Column
    private Date startDate;

    @Column
    private String name;

    @ApiModelProperty(value = "スケジュールID", position = 0)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ApiModelProperty(value = "更新日時", position = 7)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @ApiModelProperty(value = "削除フラグ", position = 8)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @ApiModelProperty(value = "開催場所", position = 6)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @ApiModelProperty(value = "終了時間", position = 5)
    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @ApiModelProperty(value = "開始時間", position = 3)
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @ApiModelProperty(value = "終了日", position = 4)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @ApiModelProperty(value = "開始日", position = 2)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @ApiModelProperty(value = "予定名", position = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
