
def applicationContext = org.codehaus.groovy.grails.commons.ApplicationHolder.application.mainContext
def jqueryPlugin = applicationContext.pluginManager.getGrailsPlugin('jquery')
def jqueryUiPlugin = applicationContext.pluginManager.getGrailsPlugin('jquery-ui')

modules = {
	
	"elfinder-css" {
		resource id:"css", url:[plugin:'elfinder-resources', dir:'css', file:'elfinder.min.css'], disposition: 'head', nominify: true
	}

	"elfinder-theme" {
		resource id:"css", url:[plugin:'elfinder-resources', dir:'css', file:'theme.css'], disposition: 'head'
	}

	"elfinder" {

		if(jqueryPlugin) {
			dependsOn "jquery"
		}
		if(jqueryUiPlugin) {
			dependsOn "jquery-ui"
		}

		dependsOn "elfinder-css"
		resource id:"js", url:[plugin:'elfinder-resources', dir:'js', file:'elfinder.min.js'], nominify: true
	}
}