def call(Map args = [:]) {
  args.params.each { name, value ->
    echo "${name}=${value}"
  }
}