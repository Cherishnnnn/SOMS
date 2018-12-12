CREATE DATABASE Shoms    -- �������ݿ�
GO
-- ����Ϊ���������SQL����

USE Shoms
--����
CREATE TABLE [dbo].[Patient](
[P_ID] [int] IDENTITY(1,1)  ,
[P_Name] [varchar](20)  ,
[P_Sex] [varchar](10) check (P_Sex = '��'or P_Sex = 'Ů') ,
[P_Age][int]  ,
[P_PN] [char](11),
[P_Balance][money] NOT NULL, 
CONSTRAINT [PK_Patient] PRIMARY KEY CLUSTERED ([P_ID] ASC ));

--ҽ��
CREATE TABLE [dbo].[Doctor](
[D_ID] [int] IDENTITY(1,1)  ,
[D_Name] [varchar](20)  ,
[D_Department] [varchar](10) ,
[D_PN] [char](11)  ,
[D_Title][char](10)  , 
CONSTRAINT [PK_Doctor] PRIMARY KEY CLUSTERED ([D_ID] ASC ));

--��Ӧ��
CREATE TABLE [dbo].[MSupplier](
[S_ID] [int] IDENTITY(1,1)  ,
[S_Name] [varchar](20)  ,
[S_PN] [char](11)  ,
[S_Address][char](40)  , 
CONSTRAINT [PK_MSupplier] PRIMARY KEY CLUSTERED ([S_ID] ASC ));

--ҩƷ
CREATE TABLE [dbo].[Medicine](
[M_ID] [int] IDENTITY(1,1)  ,
[M_Name] [varchar](20)  ,
[M_Price] [money]  ,
[M_ExpiryDate][date]  ,
[M_Specification][char](20)  ,
[M_Stock][int]  , 
CONSTRAINT [PK_Medicine] PRIMARY KEY CLUSTERED ([M_ID] ASC ));

--�Һ�
CREATE TABLE [dbo].[Registration](
[R_ID] [int] IDENTITY(1,1)  ,
[P_ID] [int]   FOREIGN KEY REFERENCES Patient(P_ID),
[D_ID] [int]   FOREIGN KEY REFERENCES Doctor(D_ID),
[R_Price] [money]  ,
[R_Time][datetime]  ,
CONSTRAINT [PK_Registration] PRIMARY KEY CLUSTERED ([R_ID] ASC ));

--����
CREATE TABLE [dbo].[Recipt](
[R_ID] [int]  ,
[M_ID] [int]   FOREIGN KEY REFERENCES Medicine(M_ID),
[R_Quantity][int]  ,
CONSTRAINT [PK_Recipt] PRIMARY KEY CLUSTERED ([R_ID],[M_ID] ASC ));

--����
CREATE TABLE [dbo].[Diagnosis](
[P_ID] [int]   FOREIGN KEY REFERENCES Patient(P_ID),
[D_ID] [int]   FOREIGN KEY REFERENCES Doctor(D_ID),
[R_ID] [int]   ,
[D_Date][date]  , 
[D_Condition] [text],
[D_Price][money]  ,
CONSTRAINT [PK_Diagnosis] PRIMARY KEY CLUSTERED ([P_ID],[D_ID],[D_Date] ASC ));

--�ɹ�
CREATE TABLE [dbo].[Purchase](
[M_ID] [int]   FOREIGN KEY REFERENCES Medicine(M_ID),
[S_ID] [int]   FOREIGN KEY REFERENCES MSupplier(S_ID),
[P_Date][date]  ,
[P_Qulity] [int]  ,
[P_Price][money]  ,
[P_Buyer][char](20)  ,
CONSTRAINT [PK_Purchase] PRIMARY KEY CLUSTERED ([M_ID],[S_ID],[P_Date] ASC ));


--����Ա
CREATE TABLE [dbo].[Admin](
[A_ID] [int]  IDENTITY(1,1) ,
[A_Name] [varchar](20),
[A_Password][varchar](20)  ,
[A_Authority][char](20),
CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED ([A_ID]ASC ));










