create table public.place_location
(
    id   bigserial
        primary key,
    name varchar(256) not null
        unique
);

alter table public.place_location
    owner to postgres;

create table public.condition
(
    id          bigserial
        primary key,
    description varchar(256) not null
        unique
);

alter table public.condition
    owner to postgres;

create table public.weather_report
(
    id                              bigserial
        primary key,
    temperature_celsius             real                                not null,
    atmosphere_pressure_hectopascal real                                not null,
    air_humidity                    integer                             not null,
    condition_id                    bigint                              not null
        constraint weather_report_weather_report__fk2
            references public.condition,
    place_location_id               bigint                              not null
        constraint weather_report_weather_report__fk
            references public.place_location,
    post_date                       timestamp default CURRENT_TIMESTAMP not null,
    wind_meters_per_hour            real                                not null
);

alter table public.weather_report
    owner to postgres;


