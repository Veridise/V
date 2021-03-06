******************************
The [V] Specification Language
******************************

[V] is a specification language for communicating tests/properties to the Veridise infrastructure. It is a language independent specification language capable of expressing complex properties while maintaining readability. 

Getting Started
===============

[V] consists of a series of sections that are organized into a structure called a specification. Most sections are made up of :doc:`[V] Statements<statements>` that specify a test or property. The following sections can be used in a specification:
 * :doc:`Variables <vars>`
 * :doc:`Initializer <init>` 
 * :doc:`Test <test>`
 * :doc:`invariants <invariant>` 
 * :doc:`Temporal Properties <index>` 

Specifications
==============

[V] supports several different types of specifications that can be used to perform different tasks. Currently we support the following types of specifications:
 * :doc:`Behavioral Specifications <statements>` 
 * :doc:`Invariant Specifications<statements>`
 * :doc:`Temporal Specifications<statements>`

Tools
=====

A number of tools either require a [V] specification as an input, or produce a [V] specification as an output. Below is a list of tools that interact with the [V] specification language:
 * Eurus

Installation
============



.. toctree::
   :maxdepth: 3
   :caption: Contents:

   statements
   vars
   init
   test
   invariant
