package com.remainsoftware.featureexplorer.internal;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.osgi.framework.Bundle;

public final class ViewerComparatorExtension extends ViewerComparator {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof IBundleGroupProvider) {
			return super.compare(viewer, ((IBundleGroupProvider) e1).getName(), ((IBundleGroupProvider) e2).getName());
		}
		if (e1 instanceof IBundleGroup) {
			return super.compare(viewer, ((IBundleGroup) e1).getIdentifier(), ((IBundleGroup) e2).getIdentifier());
		}
		if (e1 instanceof Bundle) {
			return super.compare(viewer, ((Bundle) e1).getSymbolicName(), ((Bundle) e2).getSymbolicName());
		}
		return super.compare(viewer, e1, e2);
	}
}