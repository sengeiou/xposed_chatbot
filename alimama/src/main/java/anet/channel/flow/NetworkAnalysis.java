package anet.channel.flow;

public class NetworkAnalysis {
    private static volatile INetworkAnalysis networkAnalysis = new AnalysisProxy((INetworkAnalysis) null);

    public static INetworkAnalysis getInstance() {
        return networkAnalysis;
    }

    public static void setInstance(INetworkAnalysis iNetworkAnalysis) {
        networkAnalysis = new AnalysisProxy(iNetworkAnalysis);
    }

    private static class AnalysisProxy implements INetworkAnalysis {
        private INetworkAnalysis networkAnalysis = null;

        AnalysisProxy(INetworkAnalysis iNetworkAnalysis) {
            this.networkAnalysis = iNetworkAnalysis;
        }

        public void commitFlow(FlowStat flowStat) {
            if (this.networkAnalysis != null) {
                this.networkAnalysis.commitFlow(flowStat);
            }
        }
    }
}
