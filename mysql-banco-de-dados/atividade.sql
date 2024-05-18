create database techconnect;

use techconnect;

create table tbl_Usuario(
	idUsuario int primary key auto_increment,
    nmUsuario varchar(50) not null,
    idade varchar (3),
    noCpf varchar(14) not null,
    dsEmail varchar(50) not null,
    Sexo varchar(10) not null
);
select * from tbl_Usuario;
-- drop table tbl_Usuario;

create table tbl_Adm(
	idAdm int primary key auto_increment,
    nmAdm varchar(50) not null,
    noCpfAdm varchar(14) not null
);
select * from tbl_Adm;
-- drop table tbl_Adm;


create table tbl_Evento(
	idEvento int primary key auto_increment,
    nomeEvento varchar(50),
    descricaoEvento varchar(100),
    dataInicioEvento date,
    dataFinalEvento date
);
select * from tbl_Evento;
-- drop * from tbl_Evento;


-- PROCEDURES

-- Procedure selecionar tbl_Usuario
drop procedure if exists sp_SelecionaTblUsuario;
delimiter !!
create procedure sp_SelecionaTblUsuario(
)
begin
	start transaction;
		select * from tbl_Usuario;
	commit;
		Rollback;
end !!
delimiter ;

Call sp_SelecionaTblUsuario();

-- Procedure selecionar pessoa tbl_Adm
drop procedure if exists sp_SelecionaPessoaTblAdm;
delimiter !!
create procedure sp_SelecionaPessoaTblAdm(
	in p_nmAdm varchar (50),
    in p_noCpfAdm varchar (14)
)
begin
	 declare v_count int;

    start transaction;

    select count(*) into v_count from tbl_Adm where nmAdm = p_nmAdm and noCpfAdm = p_noCpfAdm;

    if v_count = 0 then
        rollback;
        signal sqlstate '45000' set message_text = 'Nenhum registro encontrado para os parâmetros fornecidos.';
    else
        select * from tbl_Adm where nmAdm = p_nmAdm and noCpfAdm = p_noCpfAdm;
        commit;
    end if;
end !!
delimiter ;

Call sp_SelecionaPessoaTblAdm();

-- Procedure selecionar pessoa tbl_Usuario
drop procedure if exists sp_SelecionaPessoaTblUsuario;
delimiter !!
create procedure sp_SelecionaPessoaTblUsuario(
	in p_nmUsuario varchar (50),
    in p_noCpf varchar (14)
)
begin
	 declare v_count int;

    start transaction;

    select count(*) into v_count from tbl_Usuario where nmUsuario = p_nmUsuario and noCpf = p_noCpf;

    if v_count = 0 then
        rollback;
        signal sqlstate '45000' set message_text = 'Nenhum registro encontrado para os parâmetros fornecidos.';
    else
        select * from tbl_Usuario where nmUsuario = p_nmUsuario and noCpf = p_noCpf;
        commit;
    end if;
end !!
delimiter ;

Call sp_SelecionaPessoaTblUsuario("Ric","476");


-- Procedure cadastrar usuario.
drop procedure if exists sp_CadastroUsuario;
delimiter !!
create procedure sp_CadastroUsuario(
	in p_nmUsuario varchar(50),
    in p_idade varchar (3),
    in p_noCpf varchar(14),
    in p_dsEmail varchar(50),
    in p_Sexo varchar(10) 
)
begin
	start transaction;
		insert into tbl_Usuario (nmUsuario,idade,noCpf,dsEmail,Sexo)
        values (p_nmUsuario,p_idade,p_noCpf,p_dsEmail,p_Sexo);
	commit;
		Rollback;
end !!
delimiter ;

Call sp_CadastroUsuario("Ricardo","12","47629297866","ricado@gmail.com","Masculino");


-- Procedure selecionar tbl_Evento
drop procedure if exists sp_SelecionaTblEvento;
delimiter !!
create procedure sp_SelecionaTblEvento(
)
begin
	start transaction;
		select * from tbl_Evento;
	commit;
		Rollback;
end !!
delimiter ;

Call sp_SelecionaTblEvento();


-- Procedure cadastrar evento.
drop procedure if exists sp_CadastroEvento;
delimiter !!
create procedure sp_CadastroEvento(
	in p_nomeEvento varchar(50),
    in p_descricaoEvento varchar(100),
    in p_dataInicioEvento date,
    in p_dataFinalEvento date
)
begin
	start transaction;
		insert into tbl_Evento (nomeEvento,descricaoEvento,dataInicioEvento,dataFinalEvento)
        values (p_nomeEvento,p_descricaoEvento,p_dataInicioEvento,p_dataFinalEvento);
	commit;
		Rollback;
end !!
delimiter ;

Call sp_CadastroEvento("Evento 1","Evento muito legal",'2024-04-26','2024-04-27');