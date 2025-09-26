def call(Map args = [:]) {
  def output = args.params.sort().collect { name, value ->
    "${name}=${value}"
  }.join('\n')
  echo '>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PARAMS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>'
  echo output
  echo '<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<'
}