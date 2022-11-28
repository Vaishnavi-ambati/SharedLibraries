def newDownload(repo)
{
  git "https://github.com/intelliqittrainings/${repo}"
}

def newBuild()
{
  sh 'mvn package'
}

def newDeploy(jobName,ip,appName)
{
  sh "scp /var/lib/jenkins/workspace/${jobName}/webapp/target/webapp.war ubuntu@${ip}:/var/lib/tomcat9/webapps/${appName}.war"
}

def runSelenium(jobName)
{
  sh 'java -jar /var/lib/jenkins/workspace/${jobName}/testing.jar
}
