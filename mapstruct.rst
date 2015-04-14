:skip-help: true
:css: css/mapstruct.css

.. title: Mapstruct

----

Mapstruct
=========

Lightning talk
--------------

BordeauxJUG 16 avril 2015
~~~~~~~~~~~~~~~~~~~~~~~~~

----

Moi
===

Christophe Labouisse
--------------------

* Développeur Java Freelance
* Mais pas que …
* Blog : http://www.labouisse.com/
* Twitter : `@XtlCnslt <https://twitter.com/XtlCnslt>`


----

Des Mappers & des Hommes
========================

On a besoin d'un *mapper* dès que l'on doit **copier** des données entre des objets (beans).

Dans la vraie vie ça arrive tout le temps :

* DTOs
* Entités
* Objets métiers

----

Manu Devolopperi
================

On peut très bien écrire de mappers à la main :

.. code:: java

  public PersonDTO convert(PersonEntity entity) {
      dto = new PersonDTO();
      dto.setName(entity.getName());
      return dto;
  }


----

:data-x: 3200
:data-y: 2700

Vraiment ?
==========

    Écrire un mapper c'est comme éplucher une patate, on y arrive sans outils mais avec c'est vraiment plus simple

Ma mère grand

----

:data-rotate-x: 90
:data-x: r0
:data-y: r0


.. image:: img/willy-waller.gif
    :height: 675px
    :width: 960px

----

:data-rotate-x: 0
:data-x: r2000

Les bibliothèques existantes
============================

Il y a plein de bibliothèques pour créer *automagiquement* des mappers plus ou moins simplement.

* Dozer
* Orika
* MapStruct
* JMapper
* …

TODO page de stackoverflow avec la liste des mappers

----

Comparaison des performances
============================

Benchmark jmh avec 4 systèmes :

* Dozer
* Orika
* MapStruct
* À la main

----

Dozer
=====

7500 mappings par seconde

----

Orika
=====

150000 mappings par seconde

----

MapStruct
=========

765000 mappings par seconde

----

Manuellement
============

980000 mappings par seconde

----

Exemple
=======

Mapper vers un DTO
------------------

----

Les objets
==========

.. code:: java

    public class Car {
        private String make;
        private int numberOfSeats;
        private CarType type;
    }


.. code:: java

    public class CarDto {
        private String manufacturer;
        private int seatCount;
        private String type;
    }

----

Quelques difficultés
====================

* les noms ne sont pas les mêmes
    * ``make``-> ``manufacturer``
    * ``numberOfSeats`` -> ``seatCount``
* ``type`` est une enum dans ``Car`` et un ``String`` dans ``CarDto``

----

Définition du mapper
====================

.. code:: java

    @Mapper
    public interface CarMapper {
        @Mappings({
                @Mapping(source = "make",
                         target = "manufacturer"),
                @Mapping(source = "numberOfSeats",
                         target = "seatCount")
        })
        CarDto carToCarDto(Car car);
    }

----

Exemple
=======

Code généré
-----------

.. code:: java

    public class CarMapperImpl implements CarMapper {
        @Override
        public CarDto carToCarDto(Car car) {
            if ( car == null ) {
                return null;
            }
            CarDto carDto = new CarDto();
            carDto.setSeatCount( car.getNumberOfSeats() );
            carDto.setManufacturer( car.getMake() );
            if ( car.getType() != null ) {
                carDto.setType( car.getType().toString() );
            }
            return carDto;
        }
    }

----

Utiliser un mapper
==================

* Manuellement :

.. code:: java

    Mappers.getMapper(CarMapper.class);


* Définir explicitement un framework d'injection :

.. code:: java

    @Mapper(componentModel = "default")
    @Mapper(componentModel = "cdi")
    @Mapper(componentModel = "spring")
    @Mapper(componentModel = "jsr330")


* Configurer le comportement par défaut du générateur :

.. code:: properties

    mapstruct.defaultComponentModel=cdi


----

Plus compliqué
==============

On veut ajouter le prix dans le DTO :

.. code:: java

    private double price;
    private String validity;


Le prix provient de ``CarPrice`` :

.. code:: java

    public class CarPrice {
        private BigDecimal value;
        private LocalDateTime validity;
    }


----

Définition du mapper
====================

.. code:: java

    @Mapper(componentModel = "default")
    public interface CarMapper {
        @Mappings({
                @Mapping(source = "car.make",
                         target = "manufacturer"),
                @Mapping(source = "car.numberOfSeats",
                         target = "seatCount"),
                @Mapping(source = "price.value",
                         target = "price")
        })
        CarDto carToCarDto(Car car, CarPrice price);
    }


----

Code généré
===========

.. code:: java

    public CarDto carToCarDto(Car car, CarPrice price) {
        if ( car == null && price == null ) {
            return null;
        }
        CarDto carDto = new CarDto();
        if ( car != null ) {
            // …
        }
        if ( price != null ) {
            // …
        }
        return carDto;
    }

----

Code généré
===========

.. code:: java

    if ( price != null ) {
        if ( price.getValue() != null ) {
            carDto.setPrice( price.getValue().doubleValue() );
        }
        if ( price.getValidity() != null ) {
            carDto.setValidity(
              DateTimeFormatter.ISO_LOCAL_DATE_TIME
                .format(price.getValidity()));
        }
    }

----

Fonctionnalités
===============

#. Les dates : Java, Joda Time, Java 8
#. Objets imbriqués
#. Collections & Maps
#. *Object factories*
#. Décorateurs

----

Les trucs pas cool
==================

* Génération de code
    * Configuration Maven/Gradle
    * Il faut se battre (un peu) avec les IDE
    * Peut demander un peu de travail avec Jaxb
    * Ne fonctionne pas (facilement) avec Lombok
* Projet jeune version 1.0.0-beta4
* Objets immuables

----

Objets immuables
================

Pojo avec des champs ``final`` :

.. code:: java

  public PersonDTO convert(PersonEntity entity) {
      dto = new PersonDTO(entity.getName());
      return dto;
  }


MapStruct ne sait pas encore le faire : https://github.com/mapstruct/mapstruct/issues/73

----

Contournement
=============

Utiliser un *builder*

.. code:: java

    @Mapper
    public abstract class CarMapper {

        public CarDto carToCarDto(Car car) {
            return carToCarDtoBuilder(car).createCarDto();
        }

        @Mappings({
                @Mapping(source = "make", target = "manufacturer"),
                @Mapping(source = "numberOfSeats", target = "seatCount")
        })
        protected abstract CarDtoBuilder carToCarDtoBuilder(Car car);
    }


----

Questions
=========

-----

Liens
=====

#. MapStruct : http://mapstruct.org/
#. Exemples : https://github.com/mapstruct/mapstruct-examples
#. Comparatif des mappers : https://github.com/jbreis/compare-java-converters
#. Les slides : coming soon
#. Prez comment rater ses benchmarks
