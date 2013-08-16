grails-elfinder-resources
=========================

Elfinder file manager integration for Grails
Plugin provides static resources for [elfinder file manager](http://elfinder.org/)

### How to use
* Step 1: * Include elfinder resource bundle in head section of page. 

```
<r:require modules="elfinder" />
```

Optionally, you can include *elfinder-theme* module.

```

<r:require modules="elfinder, elfinder-theme" />

```


* Step 2: * Initialize elfinder file manager
Plugin provides a custom tag to initialize elfinder file manager instance.

Example
```
<elfinder:init id="elfinder-container-div" controller="elfinderConnector" />

```

Any of the [client configuration option](https://github.com/Studio-42/elFinder/wiki/Client-configuration-options) can be passed as attributes to the tag.

Example : Pass list of elabled commands to client

```
<g:set var="commands" value="['open', 'reload', 'home', 'up', 'back', 'forward', 'download', 'rm', 'rename', 'mkdir', 'mkfile', 'upload', 'info', 'resize', 'short']" />
<elfinder:init id="elfinder-container-div" controller="elfinderConnector" commands="${commands}" />		

```  

 
