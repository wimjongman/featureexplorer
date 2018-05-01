package com.remainsoftware.featureexplorer.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.osgi.framework.Bundle;

public class FeatureExplorerContentProvider implements ITreeContentProvider {
	private HashMap<Long, BundleDescription> bundles;

	@Override
	public void dispose() {
	}

	@Override
	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof IBundleGroupProvider) {
			ArrayList<IBundleGroup> result = new ArrayList<IBundleGroup>();
			result.addAll(Arrays.asList(((IBundleGroupProvider) parentElement).getBundleGroups()));
			result.add(new EmptyBundleGroup(bundles));
			return result.toArray();
		}

		if (parentElement instanceof IBundleGroup) {

			if (((IBundleGroup) parentElement).getName().length() == 0) {
				ArrayList<Bundle> result = new ArrayList<Bundle>();
				for (BundleDescription bundle : bundles.values()) {
					result.add(Platform.getBundle(bundle.getSymbolicName()));
				}
				return result.toArray();
			} else {
				for (Bundle bundle : ((IBundleGroup) parentElement).getBundles()) {
					bundles.remove(bundle.getBundleId());
				}
			}

			return ((IBundleGroup) parentElement).getBundles();
		}

		return new Object[] {};
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return Platform.getBundleGroupProviders();
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		bundles = new HashMap<Long, BundleDescription>();
		if (newInput != null) {
			for (BundleDescription bundle : Platform.getPlatformAdmin().getState(false).getBundles()) {
				bundles.put(bundle.getBundleId(), bundle);
			}
		}
	}
}