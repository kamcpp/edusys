ALTER proc [dbo].[GetStudents](@ClassCode bigint)
as
	select Am_Karamuz.Code as KaramuzCode, TarafH.Code as TarafHesabCode, TarafH.Name as Name, TarafH.Famil as Family, 
	TarafH.TelPhone as Phone, TarafH.TelPhoneZarori as EmergencyPhone, 
	TarafH.BirthDate as BirthDate, TarafH.[Address] as [Address], TarafH.Email as Email, 
	Am_Shahreyeh.Reg_Date as PaymentDate, Am_Shahreyeh.Mablagh as Paid, 
	Am_Karamuz.Shahriyeh as Payment, Am_Karamuz.Takhfif as Discount, Am_Karamuz.Tozihat as [Description],
	Am_Karamuz.Reshteh as Reshteh, Am_Kelas.Name as ClassName, Am_Kelas.Code as ClassCode, Am_Karamuz.Daneshgah as Daneshgah,
	Am_Karamuz.State as [State]
	from  Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
	inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
	inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
	where Am_Kelas.Code = @ClassCode
	order by Am_Karamuz.State
	
go
	
ALTER function [dbo].[EdusysSplit]
(
    @String varchar(max)
)
returns @SplittedValues table
(
    Id bigint
)
as
begin
    declare @SplitLength int, @Delimiter varchar(5)
    
    set @Delimiter = ','
    
    while len(@String) > 0
    begin 
        select @SplitLength = (case charindex(@Delimiter,@String) when 0 then
            len(@String) else charindex(@Delimiter,@String) -1 end)
 
        insert into @SplittedValues
        select cast(substring(@String,1,@SplitLength) as bigint)
    
        select @String = (case (len(@String) - @SplitLength) when 0 then  ''
            else right(@String, len(@String) - @SplitLength - 1) end)
    end 
return  
end

go

alter proc GetTerms
as
  select Code, Name from dbo.Am_Terms where Name like '%1392%';
  
go

alter proc GetGroups
as
  select Code, Name, Tozihat from dbo.Am_KelasGrp;
  
go

ALTER proc [dbo].[GetClasses](@GroupCodes nvarchar(max), @TermCodes nvarchar(max), @ClassNamePattern nvarchar(500), @ShowAll int, @ClassName nvarchar(max), @ClassCode bigint)
as

  if (@ClassCode > 0)
  begin
    select TarafH.Code as TeacherTarafHesabCode, TarafH.Name as TeacherName, TarafH.Famil as TeacherFamily, N'' as TeacherPhone1,
           N'' as TeacherPhone2, N'' as TeacherEmail, 
           Am_Kelas.Code, Active_Days + '(' + Active_Times + ')' as Active_Days, Am_Kelas.Name, Am_Kelas.Tozihat, T.NumberOfStudents, [Start_Date] as StartDate,
           [End_Date] as EndDate
           from
        dbo.AM_Kelas inner join  (select TT.ClassCode, count(*) as NumberOfStudents
	   						from  ( select distinct Am_Kelas.Code as ClassCode, Am_Karamuz.Code as KaramuzCode
									from Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
										 inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
										 inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
										 where Am_Karamuz.State = 0) as TT
										 group by TT.ClassCode) as T on Am_Kelas.Code = T.ClassCode
					 inner join dbo.AM_ASATED on Am_Kelas.Code_Ostad = Am_ASATED.Code
					 inner join TarafH on TarafH.Code = Am_ASATED.Code_TarafH
        where Am_Kelas.Code = @ClassCode
        order by T.NumberOfStudents desc
  end
  else
  begin
    if (@ClassNamePattern is null)
    begin
      if (@ShowAll = 1)
      begin
           select TarafH.Code as TeacherTarafHesabCode, TarafH.Name as TeacherName, TarafH.Famil as TeacherFamily, N'' as TeacherPhone1,
           N'' as TeacherPhone2, N'' as TeacherEmail, 
           Am_Kelas.Code, Active_Days + '(' + Active_Times + ')' as Active_Days, Am_Kelas.Name, Am_Kelas.Tozihat, T.NumberOfStudents, [Start_Date] as StartDate,
           [End_Date] as EndDate from
        dbo.AM_Kelas inner join  (select TT.ClassCode, count(*) as NumberOfStudents
	   						from  ( select distinct Am_Kelas.Code as ClassCode, Am_Karamuz.Code as KaramuzCode
									from Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
										 inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
										 inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
										 where Am_Karamuz.State = 0) as TT
										 group by TT.ClassCode) as T on Am_Kelas.Code = T.ClassCode
					 inner join dbo.AM_ASATED on Am_Kelas.Code_Ostad = Am_ASATED.Code
					 inner join TarafH on TarafH.Code = Am_ASATED.Code_TarafH
        where Code_grp in (select Id from dbo.EduSysSplit(@GroupCodes)) AND Code_Term in (select Id from dbo.EduSysSplit(@TermCodes))
        order by T.NumberOfStudents desc
      end
      else
      begin
           select TarafH.Code as TeacherTarafHesabCode, TarafH.Name as TeacherName, TarafH.Famil as TeacherFamily, N'' as TeacherPhone1,
           N'' as TeacherPhone2, N'' as TeacherEmail, 
           Am_Kelas.Code, Active_Days + '(' + Active_Times + ')' as Active_Days, Am_Kelas.Name, Am_Kelas.Tozihat, T.NumberOfStudents, [Start_Date] as StartDate,
           [End_Date] as EndDate from
        dbo.AM_Kelas inner join  (select TT.ClassCode, count(*) as NumberOfStudents
	   						from  ( select distinct Am_Kelas.Code as ClassCode, Am_Karamuz.Code as KaramuzCode
									from Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
										 inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
										 inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
										 where Am_Karamuz.State = 0) as TT
										 group by TT.ClassCode) as T on Am_Kelas.Code = T.ClassCode
					inner join dbo.AM_ASATED on Am_Kelas.Code_Ostad = Am_ASATED.Code
					 inner join TarafH on TarafH.Code = Am_ASATED.Code_TarafH
        where Code_grp in (select Id from dbo.EduSysSplit(@GroupCodes)) AND Code_Term in (select Id from dbo.EduSysSplit(@TermCodes)) AND Am_Kelas.Name not like N'#%' AND Am_Kelas.Name not like N'*%'
        order by T.NumberOfStudents desc
      end
    end
    else
    begin
          select TarafH.Code as TeacherTarafHesabCode, TarafH.Name as TeacherName, TarafH.Famil as TeacherFamily, N'' as TeacherPhone1,
           N'' as TeacherPhone2, N'' as TeacherEmail, 
           Am_Kelas.Code, Active_Days + '(' + Active_Times + ')' as Active_Days, Am_Kelas.Name, Am_Kelas.Tozihat, T.NumberOfStudents, [Start_Date] as StartDate,
           [End_Date] as EndDate from
       dbo.AM_Kelas inner join  (select TT.ClassCode, count(*) as NumberOfStudents
	   						from  ( select distinct Am_Kelas.Code as ClassCode, Am_Karamuz.Code as KaramuzCode
									from Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
										 inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
										 inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
										 where Am_Karamuz.State = 0) as TT
										 group by TT.ClassCode) as T on Am_Kelas.Code = T.ClassCode
					inner join dbo.AM_ASATED on Am_Kelas.Code_Ostad = Am_ASATED.Code
					 inner join TarafH on TarafH.Code = Am_ASATED.Code_TarafH
      where Code_grp in (select Id from dbo.EduSysSplit(@GroupCodes)) AND Code_Term in (select Id from dbo.EduSysSplit(@TermCodes)) AND Am_Kelas.Name like @ClassNamePattern
      order by T.NumberOfStudents desc
    end
  end   
    
  
go
	
ALTER proc [dbo].[SearchStudents]
(
  @Name nvarchar(max),
  @Family nvarchar(max)
)
as
  
  if (@Name is not null and @Family is null)
  begin
	  select Am_Karamuz.Code as KaramuzCode, TarafH.Code as TarafHesabCode, TarafH.Name as Name, TarafH.Famil as Family, 
		TarafH.TelPhone as Phone, TarafH.TelPhoneZarori as EmergencyPhone, 
		TarafH.BirthDate as BirthDate, TarafH.[Address] as [Address], TarafH.Email as Email, 
		Am_Shahreyeh.Reg_Date as PaymentDate, Am_Shahreyeh.Mablagh as Paid, 
		Am_Karamuz.Shahriyeh as Payment, Am_Karamuz.Takhfif as Discount, Am_Karamuz.Tozihat as [Description],
		Am_Karamuz.Reshteh as Reshteh, Am_Kelas.Name as ClassName, Am_Kelas.Code as ClassCode, Am_Karamuz.Daneshgah as Daneshgah,
		Am_Karamuz.State as [State]
		from  Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
		inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
		inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
		where TarafH.Name like @Name
  end
  
  if (@Name is null and @Family is not null)
  begin
	  select Am_Karamuz.Code as KaramuzCode, TarafH.Code as TarafHesabCode, TarafH.Name as Name, TarafH.Famil as Family, 
		TarafH.TelPhone as Phone, TarafH.TelPhoneZarori as EmergencyPhone, 
		TarafH.BirthDate as BirthDate, TarafH.[Address] as [Address], TarafH.Email as Email, 
		Am_Shahreyeh.Reg_Date as PaymentDate, Am_Shahreyeh.Mablagh as Paid, 
		Am_Karamuz.Shahriyeh as Payment, Am_Karamuz.Takhfif as Discount, Am_Karamuz.Tozihat as [Description],
		Am_Karamuz.Reshteh as Reshteh, Am_Kelas.Name as ClassName, Am_Kelas.Code as ClassCode, Am_Karamuz.Daneshgah as Daneshgah,
		Am_Karamuz.State as [State]
		from  Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
		inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
		inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
		where TarafH.Famil like @Family
  end
  
  if (@Name is not null and @Family is not null)
  begin
	  select Am_Karamuz.Code as KaramuzCode, TarafH.Code as TarafHesabCode, TarafH.Name as Name, TarafH.Famil as Family, 
		TarafH.TelPhone as Phone, TarafH.TelPhoneZarori as EmergencyPhone, 
		TarafH.BirthDate as BirthDate, TarafH.[Address] as [Address], TarafH.Email as Email, 
		Am_Shahreyeh.Reg_Date as PaymentDate, Am_Shahreyeh.Mablagh as Paid, 
		Am_Karamuz.Shahriyeh as Payment, Am_Karamuz.Takhfif as Discount, Am_Karamuz.Tozihat as [Description],
		Am_Karamuz.Reshteh as Reshteh, Am_Kelas.Name as ClassName, Am_Kelas.Code as ClassCode, Am_Karamuz.Daneshgah as Daneshgah,
		Am_Karamuz.State as [State]
		from  Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
		inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
		inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
		where TarafH.Famil like @Family and TarafH.Name like @Name
  end
  
go

alter proc GetDebtors
as

select TarafH.Code as Code, TarafH.Name as Name, TarafH.Famil as Family, 
		TarafH.TelPhone as Phone1, TarafH.TelPhoneZarori as Phone2, 
		 TarafH.[Address] as [Address], TarafH.Email as Email, t1.Diff as Debt, t1.Paid, 
		 t1.Payment as ShouldPay, t1.Discount
		from   TarafH 
		inner join  		
( select TarafH.Code as Code, sum( Am_Shahreyeh.Mablagh ) as Paid, 
		sum(Am_Karamuz.Shahriyeh) as Payment, sum(Am_Karamuz.Takhfif) as Discount,
		sum(Am_Karamuz.Shahriyeh) - sum( Am_Shahreyeh.Mablagh ) + sum(Am_Karamuz.Takhfif) as Diff
		from  Am_Kelas inner join Am_Karamuz on Am_Kelas.Code = Am_Karamuz.Code_Kelas
		inner join TarafH on TarafH.Code = Am_Karamuz.Code_ozv
		inner join Am_Shahreyeh on Am_Karamuz.Code = Am_Shahreyeh.Code_Karamuz
		where Am_Shahreyeh.Mablagh + Am_Karamuz.Takhfif < Am_Karamuz.Shahriyeh		
		group by TarafH.Code ) as t1 on TarafH.Code = t1.Code
		
		where t1.Diff > 0
		order by t1.Code desc
		
go

ALTER proc [dbo].[UpdateStudentDaneshgahValue] (@KaramuzCode bigint, @DaneshgahFieldValue nvarchar(100))
as

  update Am_Karamuz
  set
  Daneshgah = @DaneshgahFieldValue
  where Code = @KaramuzCode
  