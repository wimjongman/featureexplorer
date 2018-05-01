package com.remainsoftware.featureexplorer.internal;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

public final class ProviderColumnLabelProvider extends ColumnLabelProvider {
	@Override
	public Image getImage(Object element) {
		return null;
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IBundleGroup) {
			return ((IBundleGroup) element).getProviderName();
		}

		return "";
	}
}