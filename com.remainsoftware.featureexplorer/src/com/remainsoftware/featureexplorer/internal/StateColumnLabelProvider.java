package com.remainsoftware.featureexplorer.internal;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public final class StateColumnLabelProvider extends ColumnLabelProvider {
	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof Bundle) {
			switch (((Bundle) element).getState()) {
			case Bundle.ACTIVE:
				return "Active";
			case Bundle.INSTALLED:
				return "Installed";
			case Bundle.RESOLVED:
				return "Resolved";
			case Bundle.STARTING:
				return "Starting";
			case Bundle.STOPPING:
				return "Stopping";
			case Bundle.UNINSTALLED:
				return "Uninstalled";
			}
		}
		return "";
	}
}