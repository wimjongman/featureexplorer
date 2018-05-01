package com.remainsoftware.featureexplorer.internal;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.osgi.framework.Bundle;

public class EmptyBundleGroup implements IBundleGroup {

	private final HashMap<Long, BundleDescription> bundles;

	public EmptyBundleGroup(HashMap<Long, BundleDescription> bundles) {
		this.bundles = bundles;
	}

	@Override
	public Bundle[] getBundles() {
		ArrayList<Bundle> result = new ArrayList<Bundle>();
		for (BundleDescription bundle : bundles.values()) {
			result.add(Platform.getBundle(bundle.getSymbolicName()));
		}
		return result.toArray(new Bundle[0]);
	}

	@Override
	public String getDescription() {
		return "";
	}

	@Override
	public String getIdentifier() {
		return "";
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getProperty(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProviderName() {
		return "";
	}

	@Override
	public String getVersion() {
		return "";
	}
}
