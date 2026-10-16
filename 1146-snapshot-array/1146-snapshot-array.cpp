#include <bits/stdc++.h>
using namespace std;

class SnapshotArray {
    vector<vector<pair<int,int>>> history;   // history[index] = {(snap_id, value), ...}
    int snapId = 0;

public:
    SnapshotArray(int length) {
        history.assign(length, vector<pair<int,int>>{{0, 0}});
    }

    void set(int index, int val) {
        auto &last = history[index].back();
        if (last.first == snapId) {
            last.second = val;                          // same snap: overwrite
        } else {
            history[index].push_back({snapId, val});    // new snap: add entry
        }
    }

    int snap() {
        return snapId++;
    }

    int get(int index, int snap_id) {
        auto &h = history[index];
        int lo = 0, hi = (int)h.size() - 1, ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (h[mid].first <= snap_id) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return h[ans].second;
    }
};