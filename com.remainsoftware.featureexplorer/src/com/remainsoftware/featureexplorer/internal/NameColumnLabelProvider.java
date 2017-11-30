package com.remainsoftware.featureexplorer.internal;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public final class NameColumnLabelProvider extends ColumnLabelProvider {
	public Image getImage(Object element) {
		if (element instanceof IBundleGroupProvider)
			return Activator.instance.getImageRegistry().get(
					"/icons/bundlegroupprovider.gif");
		if (element instanceof IBundleGroup)
			return Activator.instance.getImageRegistry().get(
					"/icons/bundlegroup.gif");
		if (element instanceof Bundle)
			return Activator.instance.getImageRegistry().get(
					"/icons/bundle.gif");
		return null;
	}

	public String getText(Object element) {

		if (element instanceof IBundleGroupProvider)
			return ((IBundleGroupProvider) element).getName();
		if (element instanceof IBundleGroup)
			if (element instanceof EmptyBundleGroup)
				return "Standalone Bundles";
			else
				return ((IBundleGroup) element).getIdentifier();
		if (element instanceof Bundle)
			return ((Bundle) element).getSymbolicName();

		return "";

	}
}