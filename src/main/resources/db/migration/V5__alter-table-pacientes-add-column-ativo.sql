alter table pacientes add ativo tinyint default 1;
update pacientes set ativo = 1;