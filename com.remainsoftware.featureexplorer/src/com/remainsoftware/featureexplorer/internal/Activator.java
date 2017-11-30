package com.remainsoftware.featureexplorer.internal;

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	private static BundleContext context;
	public static Activator instance;

	public Activator() {

		Activator.instance = this;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		Activator.context = context;
		super.start(context);
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		// TODO Auto-generated method stub
		super.initializeImageRegistry(reg);

		Enumeration<?> enumer = context.getBundle().findEntries("icons",
				"*.gif", false);
		while (enumer.hasMoreElements()) {
			URL url = (URL) enumer.nextElement();
			reg.put(url.getFile(), ImageDescriptor.createFromURL(url).createImage());
		}
	}
}
