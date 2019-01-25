package com.se.team21.backend.B5911189.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public  class  AccountRecord{
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="account_seq",sequenceName="account_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_seq")
    @Column(name="idaccount",unique = true, nullable = false)
    private @NonNull Long idaccount;
    @Temporal(TemporalType.DATE)
    private @NonNull Date Savedate;
    private @NonNull String Title;
    private @NonNull String Amount;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Banks.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idBank",insertable = true)      // join colume video_id จาก video กับ entity comment
    private Banks Banks;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = IncomeExpenses.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idIncomeExpenses",insertable = true)      // join colume video_id จาก video กับ entity comment
    private IncomeExpenses IncomeExpenses;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = FromTo.class)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idFromTo",insertable = true)      // join colume video_id จาก video กับ entity comment
    private FromTo FromTo;



    public void setIdaccount(Long idAccount) { this.idaccount = idAccount; }
    public Long getIdaccount() {return idaccount;}

    public void setSavedate(Date Savedate) { this.Savedate = Savedate;}
    public Date getSavedate() {return Savedate;}

    public void setTitle(String Title) { this.Title = Title;}
    public String getTitle() { return Title ;}




    public void setAmount(String Amount) { this.Amount = Amount;}
    public String getAmount() {return Amount;}

    public void setBanks(Banks banks) { this.Banks = banks;}
    public Banks getBanks() {return Banks;}

    public void setIncomeExpenses(IncomeExpenses incomeExpenses) { this.IncomeExpenses = incomeExpenses;}
    public IncomeExpenses getIncomeExpenses() {return IncomeExpenses;}

    public void setFromto(FromTo fromTo) { this.FromTo = fromTo;}
    public FromTo getFromto() {return FromTo;}


}