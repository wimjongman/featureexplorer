package com.remainsoftware.featureexplorer.internal;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public final class VersionColumnLabelProvider extends ColumnLabelProvider {
	public Image getImage(Object element) {
		return null;
	}

	public String getText(Object element) {
		if (element instanceof IBundleGroup)
			return ((IBundleGroup) element).getVersion();
		if (element instanceof Bundle)
			return ((Bundle) element).getVersion() + "";

		return "";
	}
}