package dev.hireben.cicd

import spock.lang.Specification

class LibraryTest extends Specification {
  def someLibraryMethodReturnsTrue() {
    setup:
    def lib = new Library()

    when:
    def result = lib.someLibraryMethod()

    then:
    result == true
  }
}
