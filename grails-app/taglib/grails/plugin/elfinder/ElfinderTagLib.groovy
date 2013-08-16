package grails.plugin.elfinder

import grails.converters.JSON

/**
 * @author Sudhir Nimavat
 *
 */
class ElfinderTagLib {
	
	static namespace = "elfinder"

	/**
	 * Initialize elfinder. id and controller params are required.
	 * all of the other attributes will be passed as it is to elfinder as an option
	 * @see https://github.com/Studio-42/elFinder/wiki/Client-configuration-options 
	 * 
	 * @param id  id of the div to which this elfinder instance will be attached
	 * @param controller Name of the elfinder connector controller
	 * @param action action for the elfinder connector controller
	 * 
	 */
	def init = { attrs ->

		if(!attrs.id) {
			throwTagError("id is required")
		}

		if(!attrs.controller) {
			throwTagError("controller must be specified")
		}

		def id = attrs.remove('id')
		def controller = attrs.remove('controller')
		def action = attrs.remove('action')

		String connectorUrl = g.createLink(controller:controller, action:action)
		attrs['url'] = connectorUrl
		def options = attrs as JSON

		out << render(template:"/templates/elfinder/init", contextPath: pluginContextPath, model:[id:id, options:options])
	}
}
