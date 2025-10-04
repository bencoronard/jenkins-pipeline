def run(Map args = [:]) {
  def content = libraryResource "dev/hireben/pipeline/script/${args.file}"
  writeFile file: args.file, text: content
  sh "chmod +x ${args.file} && ./${args.file} ${args.arg}"
}