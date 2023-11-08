alter table medicos add ativo tinyint default 1;
update medicos set ativo = 1;