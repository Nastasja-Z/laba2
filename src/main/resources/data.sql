insert into Needy(name_needy, status_needy)
values('Georgia Smith', 'needy1');

insert into Needy(name_needy, status_needy)
values('Estel Bronter', 'needy2');

insert into Needy(name_needy, status_needy)
values('Pepper Miller', 'needy3');

insert into Options(name_option, price_option, option_id)
values('midi product basket', 500,(select id from Needy where name_needy='Georgia Smith'));

insert into Options(name_option, price_option, option_id)
values('mini product basket', 300,(select id from Needy where name_needy='Georgia Smith'));

