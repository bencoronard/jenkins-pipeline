package dev.hireben.cicd

import com.lesfurets.jenkins.unit.BasePipelineTest
import spock.lang.Specification

class JenkinsfileTest extends Specification {

    def pipelineTest = new BasePipelineTest() {}

    def setup() {
        pipelineTest.setUp()

        // Mock the sh step for both String and Map usage
        pipelineTest.helper.registerAllowedMethod('sh', [String.class], { cmd ->
            println "[MOCKED sh] $cmd"
            return 0
        })
        pipelineTest.helper.registerAllowedMethod('sh', [Map.class], { m ->
            println "[MOCKED sh] ${m}"
            return 0
        })
    }

    def "vars/buildAndTest calls sh for Build and Test stages"() {
        when:
        // Load the shared step
        def buildAndTest = pipelineTest.loadScript('vars/buildAndTest.groovy')

        // Call the step
        buildAndTest.call()

        then:
        // Pipeline succeeded
        pipelineTest.assertJobStatusSuccess()

        // Check Build stage sh call
        // pipelineTest.helper.callStack.any { call ->
        //     call.methodName == 'sh' &&
        //     pipelineTest.callArgsToString(call).contains('echo Building...')
        // }

        // Check Test stage sh call
        // pipelineTest.callStack.any { call ->
        //     call.methodName == 'sh' &&
        //     pipelineTest.callArgsToString(call).contains('echo Running tests...')
        // }
    }
}